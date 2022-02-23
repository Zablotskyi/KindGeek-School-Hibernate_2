import entity.Car;
import entity.Gender;
import entity.Person;
import org.hibernate.PersistentObjectException;
import repository.CarRepository;
import repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("primary");
        EntityManager manager = factory.createEntityManager();

//        PersonRepository personRepository = new PersonRepository(manager);
        // створення нового юзера
//        Person person = new Person();
//        person.setFirstName("Vasyl");
//        person.setGender(Gender.MALE);
//        personRepository.save(person);

        // апдейт нового юзера
//        Person person = new Person();
//        person.setId(1L);
//        person.setGender(Gender.MALE);
//        person.setFirstName("Vasyliovych");
//        personRepository.update(person);

        //той самий апдейт, але використовуємо метод findById
//        Person personForUpdate = personRepository.findById(1L);
//        personForUpdate.setFirstName("Vasyl");
//        personRepository.update(personForUpdate);

        //переконаємося що наш метод findById працює
//        Person personForUpdate = personRepository.findById(1L);
//        System.out.println(personForUpdate);

        //відпрацьовує метод findAll
//        personRepository.findAll().forEach(System.out::println);

        //відпрацьовує метод findAllLikeName, знаходиться все що задовольняє нашому фільтру і передається методу delete для видалення
//        personRepository.findAllLikeName("rom").forEach(personRepository::delete);

//        personRepository.findAll().forEach(System.out::println);

        //відпрацьовує метод delete
//        personRepository.delete(personRepository.findById(1L));



        PersonRepository personRepository = new PersonRepository(manager);
        CarRepository carRepository = new CarRepository(manager);

//        Car car = new Car();
//        car.setNameCar("BMW");
//        car.setPowerCar(260);
//        car.setPerson(personRepository.findById(3L));
//        carRepository.save(car);

        manager.getTransaction().begin();
        System.out.println(personRepository.findById(3L).getCars());
        manager.getTransaction().commit();


//        Person personForUpdate = personRepository.findById(1L);
//        System.out.println("Person by id: " + person.getFirstName());
//        personForUpdate.setFirstName("Pavlo");
//
//        personRepository.update(personForUpdate);
//
//        personRepository.findAll().forEach(p -> System.out.println(p.getId() + " " + p.getFirstName()));


//        personRepository.delete(personRepository.findById(1L));

        manager.close();
        factory.close();
    }
}
