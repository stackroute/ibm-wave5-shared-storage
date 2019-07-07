package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PartitionRepository extends Neo4jRepository<Partition,Integer> {

   @Query("CREATE (p:Partition) SET p.pid={pid},p.sqft={sqft},p.cost={cost}")
   Partition createPartition(long pid, long sqft, long cost);


   @Query("MATCH (n:Partition) RETURN n")
   public Collection<Partition> getAllPartitions();

   @Query("MATCH (n:Partition) WHERE n.pid={pid} DETACH DELETE n RETURN 'node deleted' ")
   public Partition deleteNode(long pid);
}
