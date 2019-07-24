package com.stackroute.service;

import com.stackroute.model.User;
import com.stackroute.model.User1;

import java.util.Collection;

public interface BookedService {
    User1 createUserRelationship(String userMail, String uuid);

    public Collection<User1> getRelationship();


}
