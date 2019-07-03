package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    public User createUser(String userMail, Partition partition);

}
