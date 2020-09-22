package com.trutsin.service.services;

import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private SessionFactory sessionFactory;

    public void createUser(User user, Session session) {
        UserDaoImpl.getInstance().create(user,session);
    }

    public User readUserById(int id, Session session) {
        return UserDaoImpl.getInstance().readById(id, session);
    }

    public void updateUser(User user, Session session) {
        UserDaoImpl.getInstance().update(user, session);
    }

    public void deleteUser(User user, Session session) {
        UserDaoImpl.getInstance().delete(user, session);
    }
}
