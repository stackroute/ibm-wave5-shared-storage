package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface LocatedInRepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (a:StorageUnit),(b:Area) WHERE a.warehouseId = {warehouseId} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, String area);

//    @Query("MATCH (a:Partition),(b:Area) WHERE a.cost = {cost} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
//    public Partition createRelationshipCost(String cost, String area);

    @Query("MATCH (a:Partition),(b:Area) WHERE a.pid = {pid} AND b.area = {area} CREATE (a)-[r:LocatedIn]->(b) RETURN r")
    public Partition createRelationshipArea(Long pid, String area);

    @Query( "MATCH (Partition)-[r:Located]->(Area) DELETE r;")
    public Partition deleteRelationshipArea();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) RETURN c.sqft")
    public ArrayList<Long> getPartitionSqft();

    @Query("MATCH (c:Partition)<-[:HasA]-(m:StorageUnit) RETURN c.sqft")
    public ArrayList<Long> getAllPartitionSqft();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) WITH distinct c as c MATCH (n:Area)<-[:LocatedIn]-(s:StorageUnit)-[HasA]-(l:Partition) WHERE c.sqft=l.sqft and s.warehouseName<>c.storageUnit RETURN s,l")
    public Collection<StorageUnit> createRecommendationSqft();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) RETURN n.area")
    public ArrayList<String> getPartitionLocation();

    @Query("MATCH (c:Partition)<-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) RETURN n.area")
    public ArrayList<String> getAllPartitionLocation();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)-[:HasA]-(m:StorageUnit)-[:LocatedIn]->(n:Area) WITH distinct n as n MATCH (s:StorageUnit)-[:LocatedIn]-(n) RETURN s")
    public Collection<Area> createRecommendationLocation();

//    @Query("MATCH (User {name:'abc'})-[b:Booked]->(c:Category)-[:Contains]-(m:Space)-[:Located]->(n:Location)
//    WITH distinct n as n
//    MATCH (User {name:'abc'})-[b:Booked]->(c:Category)-[:Contains]-(m:Space)-[:Located]->(n:Location)
//    WITH distinct c as c MATCH (s:Space)-[:Contains]->(c)  RETURN s")
//    public Collection<Space> createRecommendation();


//    MATCH (User {name:"abc"})-[b:Booked]->(c:Category)-[:Contains]-(m:Space)-[:Located]->(n:Location)
//    WITH distinct n as n
//    MATCH (s:Space)-[:Located]-(n) RETURN s



}
