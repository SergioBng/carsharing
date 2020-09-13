package com.trutsin.service;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    public void createCar(Car car) {
        carDao.create(car);
    }

    public Car readCarById(int id) {
        return carDao.readById(id);
    }

    public void updateCar(Car car) {
        carDao.update(car);
    }

    public void deleteCar(Car car) {
        carDao.delete(car);
    }
}
