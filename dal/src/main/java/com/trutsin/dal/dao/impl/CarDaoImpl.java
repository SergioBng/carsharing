package com.trutsin.dal.dao.impl;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;

public class CarDaoImpl implements CarDao {
    @Override
    public void create(Car car, Session session) {
        session.save(car);
    }

    @Override
    public Car readById(int id, Session session) {
        return session.find(Car.class, session);
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
