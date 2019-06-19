package com.stackroute.LoginService.service;

import com.stackroute.LoginService.exception.UserNotFoundException;
import com.stackroute.LoginService.model.User;
import com.stackroute.LoginService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public User saveUser(User user) throws Exception {
        if (userRepository.existsByName(user.getName())) {
            throw new Exception("user already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserIdAndPassword(String username, String password) {
        return userRepository.findByNameAndPassword(username, password);
    }

    @Override
    public boolean deleteUser(int id) throws UserNotFoundException {
        boolean status = false;
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            status = true;
            return status;

        } else {
            throw new UserNotFoundException("userId not exists");
        }

    }

}
