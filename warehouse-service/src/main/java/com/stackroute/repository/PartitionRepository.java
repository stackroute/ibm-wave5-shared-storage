package com.stackroute.repository;

import com.stackroute.model.Partition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartitionRepository extends MongoRepository<Partition, String> {

}