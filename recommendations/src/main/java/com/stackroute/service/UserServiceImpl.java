package com.stackroute.service;

import com.stackroute.model.Recommendation;
import com.stackroute.model.User1;
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
    public User1 createUser(String userMail, Recommendation recommendation) {
      return userRepository.createNode(userMail, recommendation);
    }

    @Override
    public User1 findByEmail(String userMail) {
        return userRepository.getNode(userMail);
    }

    @Override
    public Collection<User1> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User1 delete(String userMail) {
        return userRepository.deleteNode(userMail);
    }

    @Override
    public User1 deleteAll() {
        return userRepository.deleteAllNodes();
    }

    @Override
    public User1 createUserOnly(String userMail) {

        return userRepository.createUserNode(userMail);


    }
}
