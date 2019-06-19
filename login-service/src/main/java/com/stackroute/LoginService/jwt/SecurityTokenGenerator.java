package com.stackroute.LoginService.jwt;

import com.stackroute.LoginService.model.User;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User user);
}
