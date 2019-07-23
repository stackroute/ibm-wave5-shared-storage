package com.stackroute.model;


import lombok.*;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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
    private String cityName;

    StorageUnit storageUnit;

}
