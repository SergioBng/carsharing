package com.trutsin.dal;

import com.trutsin.dal.dao.impl.UserDaoImpl;
import com.trutsin.dal.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoImplTest {
    static SessionFactory sessionFactory;
    static Session session;
    static Transaction transaction;
    static UserDaoImpl UserDao;
    static User newUser;



    @BeforeAll
    static void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        newUser = new User("Genry", "Ford", "Loogss12", "wdskswWw", "Driver");
        UserDao = new UserDaoImpl();
        UserDao.create(newUser, session);
    }

    @Test
    public void getPaintingTest() {
        User userFromDb = UserDao.readById(1, session);
        assertEquals(newUser, userFromDb);
    }

    @Test
    public void createPaintingTest() {
        User user = new User("Mark", "Corv", "mark1220", "123Qw23", "driver");
        UserDao.create(user, session);
        User userFromDb = UserDao.readById(2, session);
        assertEquals(user, userFromDb);
    }

    @Test
    public void updatePaintingTest() {
        User finalUser = new User("Karl", "Ford", "Loogss12", "wdskswWw", "Driver");
        User userFromDb = UserDao.readById(1, session);
        UserDao.update(userFromDb, session);
        userFromDb.setFirstName("Karl");
        UserDao.update(userFromDb, session);
        User user = UserDao.readById(1, session);
        assertEquals(finalUser, user);
    }

    @Test
    public void deletePaintingTest() {
        User user = new User("Mark", "Corv", "mark1220", "123Qw23", "driver");
        UserDao.create(user, session);
        User userFromDb = UserDao.readById(2, session);
        UserDao.delete(userFromDb, session);
        User userAfterDelete = UserDao.readById(2, session);
        assertEquals(userAfterDelete, null);
    }

    @AfterAll
    static void closeSession() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
