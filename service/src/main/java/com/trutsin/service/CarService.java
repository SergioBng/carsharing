package com.trutsin.service;

import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;

public class CarService {
    Session session;
    private static final Object LOCK = new Object();
    private static CarService INSTANCE = null;

    public static CarService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CarService();
                }
            }
        }
        return INSTANCE;
    }

    public void createCar(Car car, Session session) {
        CarDaoImpl.getInstance().create(car, session);
    }

    public Car readCarById(int id, Session session) {
        return CarDaoImpl.getInstance().readById(id, session);
    }

    public void updateCar(Car car, Session session) {
        CarDaoImpl.getInstance().update(car, session);
    }

    public void deleteCar(Car car, Session session) {
        CarDaoImpl.getInstance().delete(car, session);
    }
}
