package com.stackroute.repository;

import com.stackroute.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, Integer> {

    Warehouse findById(int id);

}
