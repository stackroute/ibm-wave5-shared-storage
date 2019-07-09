package com.stackroute.repository;


import com.stackroute.model.Address;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends Neo4jRepository <Address,String> {

    @Query("CREATE (a:Address) SET a.area={area},a.city={city}, a.state={state}, a.country={country}")
    Address saveAddress(String area, String city, String state, String country);
}
