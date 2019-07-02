package com.stackroute.repository;

import com.stackroute.domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  HistoryRepository extends MongoRepository<History , Integer> {
}
