package com.stackroute.repository;

import com.stackroute.model.BookingIdentity;
import com.stackroute.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  HistoryRepository extends MongoRepository<History , BookingIdentity> {
}
