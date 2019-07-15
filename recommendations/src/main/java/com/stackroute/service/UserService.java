package com.stackroute.service;

import com.stackroute.model.Recommendation;
import com.stackroute.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface UserService {

    public User createUser(String userMail, Recommendation recommendation);

    public User findByEmail(String userMail);
    public Collection<User> getAllUsers();
    public User delete(String userMail);
    public User deleteAll();



}
