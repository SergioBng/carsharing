package com.trutsin.service.services;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.dao.impl.CarDaoImpl;
import com.trutsin.dal.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private CarDao carDao = new CarDaoImpl();

    @Override
    public List<Car> readAllCars() {
        return carDao.allCars();
    }
}
