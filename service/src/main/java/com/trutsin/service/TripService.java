package com.trutsin.service;

import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TripService {
    private final SessionFactory sessionFactory;

    public TripService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Trip readTripById(int id, TripService tripService) {
        return TripDaoImpl.getInstance().readById(id, tripService.sessionFactory.openSession());
    }

    public void updateTrip(Trip trip, Session session) {
        TripDaoImpl.getInstance().update(trip, session);
    }

    public void deleteTrip(Trip trip, Session session) {
        TripDaoImpl.getInstance().delete(trip, session);
    }
}
