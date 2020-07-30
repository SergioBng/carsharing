package com.trutsin.dal.dao;

import org.hibernate.Session;

public interface Dao<T> {
    void create(T t, Session session);

    T read(T t, Session session);

    void update(T t, Session session);

    void delete(T t, Session session);
}
