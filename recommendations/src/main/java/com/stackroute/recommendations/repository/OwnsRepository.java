package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Owner;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnsRepository extends Neo4jRepository<Owner, Long>
{
    @Query("MATCH (a:Owner),(b:StorageUnit) WHERE a.ownerMail = {ownerMail} AND b.warehouseId = {warehouseId} CREATE (a)-[r:Owns]->(b) RETURN r")
    public Owner createRelationship(String ownerMail,long warehouseId);

}

