package com.trutsin.dal.dao.impl;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Object LOCK = new Object();
    private static CarDaoImpl INSTANCE = null;

    public static CarDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CarDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public Car readById(int id) {
        return sessionFactory.getCurrentSession().find(Car.class, id);
    }

    @Override
    public void create(Car car, Session session) {
        session.save(car);
    }

    @Override
    public Car readById(int id, Session session) {
        return session.find(Car.class, id);
    }

    @Override
    public void update(Car car, Session session) {
        session.update(car);
    }

    @Override
    public void delete(Car car, Session session) {
        session.delete(car);
    }
}
