package com.trutsin.service;

import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private SessionFactory sessionFactory;


    public void updateTrip(Trip trip, Session session) {
        TripDaoImpl.getInstance().update(trip, session);
    }

    public void deleteTrip(Trip trip, Session session) {
        TripDaoImpl.getInstance().delete(trip, session);
    }
}
