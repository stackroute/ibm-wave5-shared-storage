package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.domain.User;

import java.util.Collection;

public interface BookedService {
    User createUserRelationship(String userMail, long pid);

    public Collection<User> getRelationship();


}
