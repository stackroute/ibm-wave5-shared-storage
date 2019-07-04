package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface UserService {
    public User createUser(String userMail, Partition partition);

    public Collection<User> getAllUsers();
    public User delete(String userMail);
    public User deleteAll();

}
