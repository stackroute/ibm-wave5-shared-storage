package com.stackroute.LoginService.service;

import com.stackroute.LoginService.exception.UserNotFoundException;
import com.stackroute.LoginService.model.User;


import java.util.List;

public interface UserService {
    User saveUser(User user) throws Exception;

    List<User> getAllUsers();  ///RETRIEVE users

    User findByUserIdAndPassword(String username, String password);

    public boolean deleteUser(int id) throws UserNotFoundException;
}
