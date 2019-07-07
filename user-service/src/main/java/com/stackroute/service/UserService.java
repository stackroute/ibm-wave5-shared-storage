package com.stackroute.service;

import com.stackroute.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) throws Exception;

    List<User> getAllUsers();  ///RETRIEVE users

    User findByEmailId(String emailId) throws Exception;

    public boolean deleteUser(int id) throws Exception;
}
