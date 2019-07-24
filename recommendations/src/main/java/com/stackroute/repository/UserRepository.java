package com.stackroute.repository;


import com.stackroute.model.Recommendation;
import com.stackroute.model.User1;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends Neo4jRepository <User1,String> {


    @Query("CREATE (u:User1) SET u.userMail={userMail} RETURN u")
    User1 createNode(String userMail, Recommendation recommendation);

    @Query("MATCH (u:User1) WHERE u.userMail={userMail} RETURN u")
    public User1 getNode(@Param("userMail") String userMail);

    @Query("MATCH (n:User1) RETURN n")
    public Collection<User1> getAllUsers();

    @Query("MATCH (n:User1) WHERE n.userMail={userMail} DETACH DELETE n RETURN 'node deleted' ")
    public User1 deleteNode(String userMail);

    @Query("MATCH (User1) DETACH DELETE User1")
    public User1 deleteAllNodes();


    @Query("CREATE (u:User1) SET u.userMail={userMail} RETURN u")
    User1 createUserNode(String userMail);
}
