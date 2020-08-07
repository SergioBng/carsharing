package com.trutsin.service;

import com.trutsin.dal.entity.User;

public class CarsharingServiceApp {
    public static void main(String[] args) {
        User userFromDb = UserService.getInstance().readUserById(4);
        System.out.println(userFromDb);
    }
}
