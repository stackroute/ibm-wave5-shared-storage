package com.stackroute.relationships;

import com.stackroute.model.Area;
import com.stackroute.model.StorageUnit;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("LocatedIn")
public class LocatedIn
{
    @GraphId
    private long id;

    @StartNode
    private StorageUnit storageUnit;

    @EndNode
    private Area area;

}
