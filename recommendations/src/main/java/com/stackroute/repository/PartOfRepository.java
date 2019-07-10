package com.stackroute.repository;

import com.stackroute.model.Area;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartOfRepository extends Neo4jRepository<Area, String>
{
    @Query("MATCH (a:Area),(b:City) WHERE a.area = {area} AND b.city = {city} CREATE (a)-[r:PartOf]->(b) RETURN r")
    public Area createRelationship(String area, String city);
}
