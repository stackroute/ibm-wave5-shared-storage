package com.stackroute.service;


import com.stackroute.model.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private User user;

    @Autowired
    private UserRepository userRepository;
    @Autowired
     private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) throws Exception {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);

        userEntity = userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    @Override
    public User findByEmailId(String emailId) throws Exception  {
        if (userRepository.existsByEmailId(emailId))
            return userRepository.findByEmailId(emailId);
        else {
            throw new Exception("emailId does not exists");
        }
    }
    @Override
    public boolean deleteUser(int id) throws Exception {
        boolean status = false;
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            status = true;
            return status;
        } else {
            throw new Exception("emailId does not exists");
        }
    }

}

