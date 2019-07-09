package com.stackroute.repository;

import com.stackroute.model.Area;
import com.stackroute.model.City;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CityRepository extends Neo4jRepository<City, String>
{
    @Query("CREATE (a:City) SET a.city={city} RETURN a")
    Area createCity(String city);

    @Query("MATCH (u:City) WHERE u.city={city} RETURN u")
    public City getNode(@Param("city") String city);

    @Query("MATCH (n:City) RETURN n")
    public Collection<City> getAllCity();
}
