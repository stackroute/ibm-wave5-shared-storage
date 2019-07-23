package com.stackroute.repository;


import com.stackroute.model.Partition;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PartitionRepository extends Neo4jRepository<Partition,Integer> {

   @Query("CREATE (p:Partition) SET p.pid={pid},p.sqft={sqft},p.cost={cost}, p.cityName={cityName}")
   Partition createPartition(long pid, long sqft, long cost, String cityName);

   @Query("MATCH (n:Partition) WHERE n.pid={pid} RETURN n")
   public Partition getNode(@Param("pid") long pid);

   @Query("MATCH (n:Partition) RETURN n")
   public Collection<Partition> getAllPartitions();

   @Query("MATCH (n:Partition) WHERE n.pid={pid} DETACH DELETE n RETURN 'node deleted' ")
   public Partition deleteNode(long pid);

   @Query("MATCH (n:Partition) WHERE n.pid={pid} SET n.cost={cost} RETURN n")
   public Partition updateNode(long pid,long sqft, long cost);
}
