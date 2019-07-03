package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends Neo4jRepository <User,String> {


    @Query("CREATE (u:User) SET u.userMail={userMail},u.partition={partition} RETURN u")
    User saveNode(String userMail, Partition partition);


}
