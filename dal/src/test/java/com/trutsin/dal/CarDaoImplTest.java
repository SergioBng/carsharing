package com.trutsin.dal;

import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.Car;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarDaoImplTest {
    static SessionFactory sessionFactory;
    static Session session;
    static Transaction transaction;
    static CarDaoImpl CarDao;
    static Car newCar;



    @BeforeAll
    static void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        newCar = new Car("Skoda Rapid");
        CarDao = new CarDaoImpl();
        CarDao.create(newCar, session);
    }

    @Test
    public void getPaintingTest() {
        Car carFromDb = CarDao.readById(1, session);
        assertEquals(newCar, carFromDb);
    }

    @Test
    public void createPaintingTest() {
        Car car =new Car("Volkswagen Polo");
        CarDao.create(car, session);
        Car carFromDb = CarDao.readById(2, session);
        assertEquals(car, carFromDb);
    }

    @Test
    public void updatePaintingTest() {
        Car finalCar = new Car("Skoda Kodiaq");
        Car carFromDb = CarDao.readById(1, session);
        CarDao.update(carFromDb, session);
        carFromDb.setModel("Skoda Kodiaq");
        CarDao.update(carFromDb, session);
        Car car = CarDao.readById(1, session);
        assertEquals(finalCar, car);
    }

    @Test
    public void deletePaintingTest() {
        Car car = new Car("Skoda Rapid");
        CarDao.create(car, session);
        Car carFromDb = CarDao.readById(2, session);
        CarDao.delete(carFromDb, session);
        Car carAfterDelete = CarDao.readById(2, session);
        assertEquals(carAfterDelete, null);
    }

    @AfterAll
    static void closeSession() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
