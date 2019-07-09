package com.stackroute.repository;

import com.stackroute.model.Partitions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartitionRepository extends MongoRepository<Partitions, String> {

}