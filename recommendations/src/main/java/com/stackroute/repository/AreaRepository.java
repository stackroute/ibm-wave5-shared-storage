package com.stackroute.repository;

import com.stackroute.model.Area;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AreaRepository extends Neo4jRepository<Area, String>
{
    @Query("CREATE (a:Area) SET a.area={area} RETURN a")
    Area createArea(String area);

    @Query("MATCH (u:Area) WHERE u.area={area} RETURN u")
    public Area getNode(@Param("area") String area);

    @Query("MATCH (n:Area) RETURN n")
    public Collection<Area> getAllArea();

    @Query("MATCH (n:Area) \n" +
            "WHERE any(x IN n.area WHERE x ={area})\n" +
            "RETURN n")
    List<Area> AreaRelationship(@Param("area")String area);



}
