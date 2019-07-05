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

   @Query("CREATE (p:Partition) SET p.pid={pid},p.area={area},p.cost={cost}")
   Partition createPartition(long pid, long area, long cost);

   @Query("MATCH (u:Partition) WHERE u.area={area} RETURN u")
   public Partition getNode(@Param("area") String area);

   @Query("MATCH (n:Partition) RETURN n")
   public Collection<Partition> getAllPartitions();
}
