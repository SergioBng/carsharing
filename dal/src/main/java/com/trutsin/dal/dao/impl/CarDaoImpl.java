package com.trutsin.dal.dao.impl;

import com.trutsin.dal.dao.CarDao;
import com.trutsin.dal.entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CarDaoImpl implements CarDao {
    private SessionFactory sessionFactory;

    private static final AtomicInteger AUTO_ID = new AtomicInteger();
    private static Map<Integer, Car> cars = new HashMap<>();

    static {
        Car car1 = new Car();
        car1.setId(AUTO_ID.getAndIncrement());
        car1.setModel("Ford Mondeo");
        cars.put(car1.getId(), car1);
        Car car2 = new Car();
        car2.setId(AUTO_ID.getAndIncrement());
        car2.setModel("VW Jetta");
        cars.put(car2.getId(), car2);
        Car car3 = new Car();
        car3.setId(AUTO_ID.getAndIncrement());
        car3.setModel("Skoda Rapid");
        cars.put(car3.getId(), car3);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Object LOCK = new Object();
    private static CarDaoImpl INSTANCE = null;

    public static CarDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CarDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Car> allCars() {
        return new ArrayList<>(cars.values());
    }

    @Override
    public void create(Car car, Session session) {
        session.save(car);
    }

    @Override
    public Car readById(int id, Session session) {
        return session.find(Car.class, id);
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
