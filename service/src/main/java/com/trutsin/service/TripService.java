package com.trutsin.service;

import com.trutsin.dal.dao.impl.TripDaoImpl;
import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.Trip;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;

public class TripService {
    Session session;

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
