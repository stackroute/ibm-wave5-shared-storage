package com.stackroute.repository;

import com.stackroute.model.Area;
import com.stackroute.model.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PartOfRepository extends Neo4jRepository<Area, String>
{
    @Query("MATCH (a:Area),(b:City) WHERE a.area = {area} AND b.city = {city} CREATE (a)-[r:PartOf]->(b) RETURN r")
    public Area createRelationship(String area, String city);

    @Query("MATCH (s:StorageUnit)-[:LocatedIn]->(l:Area)-[:PartOf]->(c:City) WHERE c.city={city} RETURN s")
    public Collection<StorageUnit> getStorageUnitCity(String city);
}
