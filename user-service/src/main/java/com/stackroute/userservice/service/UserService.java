package com.stackroute.userservice.service;

//import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;


import java.util.List;

public interface UserService {
    User saveUser(User user) throws Exception;

    List<User> getAllUsers();  ///RETRIEVE users

    User findByEmailId(String emailId) throws Exception;

    public boolean deleteUser(int id) throws Exception;
}
