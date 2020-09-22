package com.trutsin.service.services;

import com.trutsin.dal.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> readAllCars();
}
