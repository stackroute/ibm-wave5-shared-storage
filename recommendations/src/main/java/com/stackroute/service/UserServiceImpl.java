package com.stackroute.service;

import com.stackroute.model.Recommendation;
import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;
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
    public User createUser(String userMail, Recommendation recommendation) {
      return userRepository.createNode(userMail, recommendation);
    }

    @Override
    public User findByEmail(String userMail) {
        return userRepository.getNode(userMail);
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
