package com.trutsin.dal.dao.impl;

import com.trutsin.dal.dao.UserDao;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Object LOCK = new Object();
    private static UserDaoImpl INSTANCE = null;

    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void create(User user, Session session) {
        session.save(user);
    }

    @Override
    public User readById(int id, Session session) {
        return session.find(User.class, id);
    }

    @Override
    public void update(User user, Session session) {
        session.update(user);
    }

    @Override
    public void delete(User user, Session session) {
        session.delete(user);
    }
}
