package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatedInRepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (a:StorageUnit),(b:Area) WHERE a.warehouseId = {warehouseId} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, String area);
}
