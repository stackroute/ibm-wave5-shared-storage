package com.stackroute.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @GraphId
    private long id;

    @Property
    private String userMail;
//    private Partition partition;
    private Recommendation recommendation;


    @Relationship(type = "Booked",direction = Relationship.INCOMING)
    private List<Partition> partitions;


}
