package com.stackroute.relationships;

import com.stackroute.model.Partition;
import com.stackroute.model.StorageUnit;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("HasA")
public class HasA
{
    @GraphId
    private long id;

    @StartNode
    private StorageUnit storageUnit;

    @EndNode
    private Partition partition;
}
