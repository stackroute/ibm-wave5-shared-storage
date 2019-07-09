package com.stackroute.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Owner {

    @GraphId
    private long id;
    private String ownerMail;
    private StorageUnit storageUnit;
}
