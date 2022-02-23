package repository;

import entity.Gender;
import entity.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonRepository {

    private final EntityManager manager;

    public PersonRepository(EntityManager entityManager) {
        this.manager = entityManager;
    }

    public void save(Person person) {
        manager.getTransaction().begin();
        manager.persist(person);
        manager.getTransaction().commit();
    }

    public void update(Person person) {
        manager.getTransaction().begin();
        manager.merge(person);
        manager.getTransaction().commit();
    }

    public Person findById(Long id) {
        return manager
                .createQuery("select p from Person p where p.id=:id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Person> findAll() {
        return manager
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    public List<Person> findAllLikeName(String firstName) {
        return manager
                .createQuery("select p from Person p where p.firstName like:filter", Person.class)
                .setParameter("filter", "%" + firstName + "%")
                .getResultList();
    }

//    public List<Person> findAllLikeNameAnd(String firstName, int gender) {
//        return manager
//                .createQuery("select p from Person p where p.firstName like:filter and p.gender =: 1", Person.class)
//                .setParameter("filter", "%" + firstName + "%")
//                .setParameter("1", gender)
//                .getResultList();
//    }

    public void delete(Person person) {
        manager.getTransaction().begin();
        manager.remove(person);
        manager.getTransaction().commit();
    }
}
