package com.trutsin.service;

import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final SessionFactory sessionFactory;

    public CarService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
