package com.trutsin.dal;

import com.trutsin.dal.dao.UserDao;
import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.Car;
import com.trutsin.dal.entity.Trip;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CarsharingMappingApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        User user1 = new User("Mark", "Corv", "mark1220", "123Qw23", "driver");
//        User user2 = new User("Genry", "Ford", "Genry65", "12340999k", "driver");
//        Car car1 = new Car("Skoda Rapid");
//        Car car2 = new Car("Volkswagen Polo");
//        UserDaoImpl.getInstance().create(user1, session);
//        UserDaoImpl.getInstance().create(user2, session);
//        CarDaoImpl.getInstance().create(car1, session);
//        CarDaoImpl.getInstance().create(car2, session);
//
//        Trip trip1 = new Trip(12, 1, "Finished", user1, car2);
//        TripDaoImpl.getInstance().create(trip1, session);

        Trip tripFromDb = TripDaoImpl.getInstance().readById(8, session);
        String name = tripFromDb.getUser().getLastName();
        System.out.println(name);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
