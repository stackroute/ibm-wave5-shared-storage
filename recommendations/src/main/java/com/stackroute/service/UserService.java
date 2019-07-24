package com.stackroute.service;

import com.stackroute.model.Recommendation;
import com.stackroute.model.User;
import com.stackroute.model.User1;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface UserService {

    public User1 createUser(String userMail, Recommendation recommendation);

    public User1 findByEmail(String userMail);
    public Collection<User1> getAllUsers();
    public User1 delete(String userMail);
    public User1 deleteAll();

    public User1  createUserOnly(String userMail);
}
