package com.stackroute.repository;

import com.stackroute.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, Integer> {
           public UserProfile findByemailId(String email);
    }
