package com.trutsin.dal.dao;

import com.trutsin.dal.entity.Car;

public interface CarDao extends Dao<Car> {
    void create(Car car);
    Car readById(int id);
    void update(Car car);
    void delete(Car car);
}
