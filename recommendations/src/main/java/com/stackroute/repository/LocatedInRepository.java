package com.stackroute.repository;

import com.stackroute.model.Area;
import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface LocatedInRepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (a:StorageUnit),(b:Area) WHERE a.warehouseId = {warehouseId} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, String area);

    @Query("MATCH (a:Partition),(b:Area) WHERE a.pid = {pid} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
    public Partition createRelationshipArea(Long pid, String area);

    @Query( "MATCH (Partition)-[r:Located]->(Area) DELETE r;")
    public Partition deleteRelationshipArea();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) RETURN n.area")
    public ArrayList<String> getPartitionLocation();

    @Query("MATCH (c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) RETURN n.area")
    public ArrayList<String> getAllPartitionLocation();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area)<-[:LocatedIn]-(s:StorageUnit)-[HasA]-(l:Partition) RETURN s")
    public Collection<StorageUnit> createRecommendationLocation();





}
