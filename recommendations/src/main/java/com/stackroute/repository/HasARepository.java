package com.stackroute.repository;

import com.stackroute.model.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface HasARepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (u:StorageUnit)-[r:HasA]->(m:Partition) RETURN u,r,m")
    public Collection<StorageUnit> getRelationship();

    @Query("MATCH (a:StorageUnit),(b:Partition) WHERE a.warehouseId = {warehouseId} AND b.pid = {pid} CREATE (a)-[r:HasA]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit)  RETURN c.sqft")
    public ArrayList<Long> getSqft();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) RETURN c.pid")
    public ArrayList<Long> getPartitionId();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>=30 and l.sqft<=50 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange0(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>50 and l.sqft<=100 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange1(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>100 and l.sqft<=200 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange2(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>200 and l.sqft<=400 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange3(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>400 and l.sqft<=500 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange4(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>500 and l.sqft<=600 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange5(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>600 and l.sqft<=700 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange6(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>700 and l.sqft<=800 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange7(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>800 and l.sqft<=900 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange8(long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>900 and l.sqft<=8000 RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange9(long pid);


}
