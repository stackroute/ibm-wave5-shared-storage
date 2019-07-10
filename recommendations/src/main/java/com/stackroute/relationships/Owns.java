package com.stackroute.relationships;


import com.stackroute.model.Owner;
import com.stackroute.model.StorageUnit;
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
