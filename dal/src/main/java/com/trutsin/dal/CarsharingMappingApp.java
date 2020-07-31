package com.trutsin.dal;

import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.dao.impl.UserDaoImpl;
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

        User user1 = new User("Mark", "Corv", "mark1220", "123Qw23", "driver");
        User user2 = new User("Genry", "Ford", "Genry65", "12340999k", "driver");

        Trip tripFromDb = TripDaoImpl.getInstance().readById(3, session);
        System.out.println(tripFromDb);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
