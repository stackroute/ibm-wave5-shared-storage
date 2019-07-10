package com.stackroute.service;

import com.stackroute.model.Partition;
import com.stackroute.model.Recommendations;
import com.stackroute.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface UserService {

    public User createUser(String userMail, Recommendations recommendations);

    public Collection<User> getAllUsers();
    public User delete(String userMail);
    public User deleteAll();



}
