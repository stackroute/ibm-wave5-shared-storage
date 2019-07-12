package com.stackroute.repository;

import com.stackroute.model.BookedStorageUnit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookedRepository extends MongoRepository<BookedStorageUnit, Integer>
{

}