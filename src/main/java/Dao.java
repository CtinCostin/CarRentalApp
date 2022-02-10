import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class Dao {

    private SessionFactory sessionFactory;

    public Dao() {

        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/carrental");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Rares2010");
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(RentalDealer.class);
        configuration.addAnnotatedClass(RentalCentral.class);
        configuration.addAnnotatedClass(City.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public void addCar(Car newCar) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newCar);
        transaction.commit();
        session.close();
    }

    public void addUser(User newUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        transaction.commit();
        session.close();
    }

    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User").getResultList();
        session.close();
        return users;
    }

    public List<Car> getCars(){
        Session session = sessionFactory.openSession();
        List<Car> cars = session.createQuery("from Car").getResultList();
        session.close();
        return cars;
    }

    public void rentACar(int userId , int carId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.find(User.class, userId);
        Car car  = session.find(Car.class, carId);
        List<Car> cars = user.getCars();
        cars.add(car);

        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }


}


