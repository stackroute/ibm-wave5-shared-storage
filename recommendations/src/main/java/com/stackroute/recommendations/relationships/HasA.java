package com.stackroute.recommendations.relationships;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
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
