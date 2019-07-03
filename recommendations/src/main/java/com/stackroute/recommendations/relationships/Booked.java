package com.stackroute.recommendations.relationships;


import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity ("Booked")
public class Booked {

    @GraphId
    private long id;

    @StartNode
    private User user;

    @EndNode
    private Partition partition;
}
