package com.trutsin.dal;

import com.trutsin.dal.dao.TripDao;
import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.entity.Car;
import com.trutsin.dal.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripDaoImplTest {
    static SessionFactory sessionFactory;
    static Session session;
    static Transaction transaction;
    static TripDaoImpl TripDao;
    static Trip newTrip;



    @BeforeAll
    static void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        newTrip = new Trip(12, 1, "Start");
        TripDao = new TripDaoImpl();
        TripDao.create(newTrip, session);
    }

    @Test
    public void getPaintingTest() {
        Trip tripFromDb = TripDao.readById(1, session);
        assertEquals(newTrip, tripFromDb);
    }

    @Test
    public void createPaintingTest() {
        Trip trip =new Trip(20, 1, "Start");
        TripDao.create(trip, session);
        Trip tripFromDb = TripDao.readById(2, session);
        assertEquals(trip, tripFromDb);
    }

    @Test
    public void updatePaintingTest() {
        Trip finalTrip = new Trip(12, 1, "Finish");
        Trip tripFromDb = TripDao.readById(1, session);
        TripDao.update(tripFromDb, session);
        tripFromDb.setStatus("Finish");
        TripDao.update(tripFromDb, session);
        Trip trip = TripDao.readById(1, session);
        assertEquals(finalTrip, trip);
    }

    @Test
    public void deletePaintingTest() {
        Trip trip =new Trip(20, 1, "Start");
        TripDao.create(trip, session);
        Trip tripFromDb = TripDao.readById(2, session);
        TripDao.delete(tripFromDb, session);
        Trip tripAfterDelete = TripDao.readById(2, session);
        assertEquals(tripAfterDelete, null);
    }

    @AfterAll
    static void closeSession() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
