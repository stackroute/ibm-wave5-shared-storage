package com.stackroute.recommendations.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;


@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorageUnit {

    @GraphId
    private long warehouseId;
    private String ownerMail;
    private String warehouseName;

    private List<Partition> partitions;


    private Address address;
}