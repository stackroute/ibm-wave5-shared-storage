package com.stackroute.repository;


import com.stackroute.model.Recommendation;
import com.stackroute.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends Neo4jRepository <User,String> {


    @Query("CREATE (u:User) SET u.userMail={userMail} RETURN u")
    User createNode(String userMail, Recommendation recommendation);

    @Query("MATCH (u:User) WHERE u.userMail={userMail} RETURN u")
    public User getNode(@Param("userMail") String userMail);

    @Query("MATCH (n:User) RETURN n")
    public Collection<User> getAllUsers();

    @Query("MATCH (n:User) WHERE n.userMail={userMail} DETACH DELETE n RETURN 'node deleted' ")
    public User deleteNode(String userMail);

    @Query("MATCH (User) DETACH DELETE User")
    public User deleteAllNodes();

}
