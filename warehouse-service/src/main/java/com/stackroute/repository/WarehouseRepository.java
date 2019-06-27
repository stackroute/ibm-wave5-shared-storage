package com.stackroute.repository;

import com.stackroute.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, Integer> {

    Warehouse findById(int id);

}
