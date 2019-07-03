package com.stackroute.recommendations.repository;


import com.stackroute.recommendations.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRepository extends Neo4jRepository<User,Long> {

}
