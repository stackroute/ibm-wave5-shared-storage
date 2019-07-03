package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.User;

public interface BookedService {
    User createUserRelationship(String userMail, long pid);
}
