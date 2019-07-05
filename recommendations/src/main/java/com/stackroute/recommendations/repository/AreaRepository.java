package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.Area;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends Neo4jRepository<Area, String>
{
    @Query("CREATE (a:Area) SET a.area={area} RETURN a")
    Area createArea(String area);

}
