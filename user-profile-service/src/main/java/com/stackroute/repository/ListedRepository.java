package com.stackroute.repository;

import com.stackroute.model.ListedStorageUnit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListedRepository extends MongoRepository<ListedStorageUnit, Integer>
{
}
