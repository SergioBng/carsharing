package com.trutsin.service;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarServiceImpl implements CarService{
    private CarDao carDao;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    public void createCar(Car car) {
        carDao.create(car);
    }

    @Transactional
    public Car readCarById(int id) {
        return carDao.readById(id);
    }

    @Transactional
    public void updateCar(Car car) {
        carDao.update(car);
    }

    @Transactional
    public void deleteCar(Car car) {
        carDao.delete(car);
    }
}
