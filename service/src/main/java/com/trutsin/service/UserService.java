package com.trutsin.service;

import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;

public class UserService {
    Session session;
    private static final Object LOCK = new Object();
    private static UserService INSTANCE = null;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public void createUser(User user) {
        UserDaoImpl.getInstance().create(user, session);
    }

    public User readUserById(int id) {
        return UserDaoImpl.getInstance().readById(id, session);
    }

    public void updateUser(User user) {
        UserDaoImpl.getInstance().update(user, session);
    }

    public void deleteUser(User user) {
        UserDaoImpl.getInstance().delete(user, session);
    }
}
