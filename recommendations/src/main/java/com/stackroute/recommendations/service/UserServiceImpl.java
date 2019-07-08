package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import com.stackroute.recommendations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(String userMail, Partition partition) {
      return userRepository.createNode(userMail,partition);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User delete(String userMail) {
        return userRepository.deleteNode(userMail);
    }

    @Override
    public User deleteAll() {
        return userRepository.deleteAllNodes();
    }
}
