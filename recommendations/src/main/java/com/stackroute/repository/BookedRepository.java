package com.stackroute.repository;


import com.stackroute.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookedRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (a:User),(b:Partition) WHERE a.userMail = {userMail} AND b.pid = {pid} CREATE (a)-[r:Booked]->(b) RETURN r")
    public User createRelationship(String userMail,long pid);

    @Query("MATCH (u:User)-[r:Booked]->(m:Partition) RETURN u,r,m")
    public Collection<User> getRelationship();





}
