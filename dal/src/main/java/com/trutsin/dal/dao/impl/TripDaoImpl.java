package com.trutsin.dal.dao.impl;

import com.trutsin.dal.dao.TripDao;
import com.trutsin.dal.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TripDaoImpl implements TripDao {
//    private SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    private static final Object LOCK = new Object();
    private static TripDaoImpl INSTANCE = null;

    public static TripDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TripDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void create(Trip trip, Session session) {
        session.save(trip);
    }

    @Override
    public Trip readById(int id, Session session) {
        return session.find(Trip.class, id);
    }

    @Override
    public void update(Trip trip, Session session) {
        session.update(trip);
    }

    @Override
    public void delete(Trip trip, Session session) {
        session.delete(trip);
    }
}
