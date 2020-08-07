package com.trutsin.service;

import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.Car;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;

public class CarService {
    Session session;

    public void createCar(Car car) {
        CarDaoImpl.getInstance().create(car, session);
    }

    public Car readCarById(int id) {
        return CarDaoImpl.getInstance().readById(id, session);
    }

    public void updateCar(Car car) {
        CarDaoImpl.getInstance().update(car, session);
    }

    public void deleteCar(Car car) {
        CarDaoImpl.getInstance().delete(car, session);
    }
}
