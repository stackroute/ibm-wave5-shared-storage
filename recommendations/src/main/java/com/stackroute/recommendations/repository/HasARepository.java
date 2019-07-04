package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HasARepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (a:StorageUnit),(b:Partition) WHERE a.warehouseId = {warehouseId} AND b.pid = {pid} CREATE (a)-[r:HasA]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, long pid);
}
