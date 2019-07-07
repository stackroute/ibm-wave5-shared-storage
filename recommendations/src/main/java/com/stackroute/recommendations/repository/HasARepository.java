package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface HasARepository extends Neo4jRepository<StorageUnit, Long>
{
    @Query("MATCH (a:StorageUnit),(b:Partition) WHERE a.warehouseId = {warehouseId} AND b.pid = {pid} CREATE (a)-[r:HasA]->(b) RETURN r")
    public StorageUnit createRelationship(long warehouseId, long pid);

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit)  RETURN c.cost")
    public ArrayList<Long> getCost();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) RETURN c.pid")
    public ArrayList<Long> getPartitionId();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>=500 and l.cost<=1000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange0();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>1000 and l.cost<=2000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange1();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>2000 and l.cost<=3000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange2();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>3000 and l.cost<=4000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange3();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>4000 and l.cost<=5000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange4();

    @Query("MATCH (User)-[b:Booked]->(c:Partition)<-[:HasA]-(m:StorageUnit) WITH distinct c as c MATCH (l:Partition)<-[:HasA]-(s:StorageUnit) WHERE l.cost>5000 and l.cost<=6000 and c.pid=l.pid and s.warehouseId<>c.storageUnit RETURN l,s")
    public Collection<Partition> recommendationCostRange5();
}
