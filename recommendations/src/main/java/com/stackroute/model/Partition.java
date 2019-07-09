package com.stackroute.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partition {

    @GraphId
    private long id;

    @Property
    private long pid;
    private long sqft;
    private long cost;

}
