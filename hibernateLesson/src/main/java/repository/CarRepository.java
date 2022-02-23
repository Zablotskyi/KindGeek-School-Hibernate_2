package repository;

import entity.Car;
import entity.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class CarRepository {

    private final EntityManager manager;

    public CarRepository(EntityManager entityManager) {
        this.manager = entityManager;
    }

    public void save(Car car) {
        manager.getTransaction().begin();
        manager.persist(car);
        manager.getTransaction().commit();
    }


    public void update(Car car) {
        manager.getTransaction().begin();
        manager.merge(car);
        manager.getTransaction().commit();
    }

    public Car findById(Long id) {
        return manager
                .createQuery("select c from Car c where c.id=:id", Car.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Car> findAll() {
        return manager.createQuery("select c from Car c", Car.class).getResultList();
    }

    public void delete(Car car) {
        manager.getTransaction().begin();
        manager.remove(car);
        manager.getTransaction().commit();
    }

}
