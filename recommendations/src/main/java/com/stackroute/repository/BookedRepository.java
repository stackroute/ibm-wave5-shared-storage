package com.stackroute.repository;


import com.stackroute.model.User;
import com.stackroute.model.User1;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookedRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (a:User1),(b:Partition) WHERE a.userMail = {userMail} AND b.uuid = {uuid} CREATE (a)-[r:Booked]->(b) RETURN r")
    public User1 createRelationship(String userMail, String  uuid);

    @Query("MATCH (u:User1)-[r:Booked]->(m:Partition) RETURN u,r,m")
    public Collection<User1> getRelationship();





}
