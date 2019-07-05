package com.stackroute.recommendations.relationships;


import com.stackroute.recommendations.domain.Owner;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.domain.User;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("Owns")
public class Owns
{
    @GraphId
    private long id;

    @StartNode
    private Owner owner;

    @EndNode
    private StorageUnit storageUnit;
}
