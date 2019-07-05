package com.stackroute.recommendations.repository;

import com.stackroute.recommendations.domain.Area;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AreaRepository extends Neo4jRepository<Area, String>
{
    @Query("CREATE (a:Area) SET a.area={area} RETURN a")
    Area createArea(String area);

    @Query("MATCH (u:Area) WHERE u.area={area} RETURN u")
    public Area getNode(@Param("area") String area);

    @Query("MATCH (n:Area) RETURN n")
    public Collection<Area> getAllArea();

}
