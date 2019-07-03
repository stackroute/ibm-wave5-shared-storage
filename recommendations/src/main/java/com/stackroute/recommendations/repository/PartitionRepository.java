package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Partition;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartitionRepository extends Neo4jRepository<Partition,Integer> {

   @Query("CREATE (p:Partition) SET p.pid={pid},p.area={area},p.cost={cost}")
   Partition createPartition(long pid, long area, long cost);
}
