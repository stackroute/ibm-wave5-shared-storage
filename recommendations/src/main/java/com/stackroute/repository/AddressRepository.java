package com.stackroute.repository;


import com.stackroute.model.Addresses;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends Neo4jRepository <Addresses,String> {

    @Query("CREATE (a:Addresses) SET a.area={area},a.city={city}, a.state={state}, a.country={country}")
    Addresses saveAddresses(String area, String city, String state, String country);
}
