package com.stackroute.repository;

import com.stackroute.model.ActivityStream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityStreamRepository extends MongoRepository<ActivityStream, Integer> {
           public ActivityStream findByemailId(String email);
    }
