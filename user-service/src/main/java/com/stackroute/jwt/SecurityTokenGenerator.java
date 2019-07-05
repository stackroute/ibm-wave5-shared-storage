package com.stackroute.jwt;

import com.stackroute.model.User;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
