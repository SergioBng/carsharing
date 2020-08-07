package com.trutsin.service;

import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.entity.Trip;
import org.hibernate.Session;

public class TripService {
    Session session;
    private static final Object LOCK = new Object();
    private static TripService INSTANCE = null;

    public static TripService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new TripService();
                }
            }
        }
        return INSTANCE;
    }

    public void createTrip(Trip trip) {
        TripDaoImpl.getInstance().create(trip, session);
    }

    public Trip readTripById(int id) {
        return TripDaoImpl.getInstance().readById(id, session);
    }

    public void updateTrip(Trip trip) {
        TripDaoImpl.getInstance().update(trip, session);
    }

    public void deleteTrip(Trip trip) {
        TripDaoImpl.getInstance().delete(trip, session);
    }
}
