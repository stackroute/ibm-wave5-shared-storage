package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.City;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends Neo4jRepository<City, String>
{
    @Query("CREATE (a:City) SET a.city={city} RETURN a")
    Area createCity(String city);
}
