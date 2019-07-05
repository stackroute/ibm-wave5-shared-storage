package com.stackroute.userservice.jwt;

import com.stackroute.userservice.model.User;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
