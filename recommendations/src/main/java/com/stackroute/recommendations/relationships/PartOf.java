package com.stackroute.recommendations.relationships;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.City;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("PartOf")
public class PartOf
{
    @GraphId
    private long id;

    @StartNode
    private Area area;

    @EndNode
    private City city;
}
