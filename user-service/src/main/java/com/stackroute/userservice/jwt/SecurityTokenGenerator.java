package com.stackroute.userservice.jwt;

import com.stackroute.userservice.model.User;
//import com.stackroute.userservice.model.UserDto;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
