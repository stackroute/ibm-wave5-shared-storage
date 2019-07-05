package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (a:User),(b:Partition) WHERE a.userMail = {userMail} AND b.pid = {pid} CREATE (a)-[r:Booked]->(b) RETURN r")
    public User createRelationship(String userMail,long pid);


}
