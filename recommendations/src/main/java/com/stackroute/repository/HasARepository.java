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

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) RETURN c.cityName")
    public ArrayList<String> getPartitionCityName();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>=30 and l.sqft<=50 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange0(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>50 and l.sqft<=100 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange1(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>100 and l.sqft<=200 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange2(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>200 and l.sqft<=400 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange3(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>400 and l.sqft<=500 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange4(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>500 and l.sqft<=600 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange5(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>600 and l.sqft<=700 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange6(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>700 and l.sqft<=800 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange7(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>800 and l.sqft<=900 and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange8(String cityName);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.sqft>900  and l.cityName={cityName} RETURN l,s")
    public Collection<StorageUnit> recommendationSqftRange9(String cityName);


}
