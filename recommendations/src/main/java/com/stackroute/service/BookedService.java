package com.stackroute.service;

import com.stackroute.model.User;

import java.util.Collection;

public interface BookedService {
    User createUserRelationship(String userMail, long pid);

    public Collection<User> getRelationship();


}
