package com.trutsin.dal.dao;

import com.trutsin.dal.entity.Car;

import java.util.List;

public interface CarDao extends Dao<Car> {
    List<Car> allCars();
}
