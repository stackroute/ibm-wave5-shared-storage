package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collection;
import java.util.List;


@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorageUnit {

    @GraphId
    private long id;

    @Property
    private long warehouseId;
    private String ownerMail;
    private String warehouseName;
    private String imageUrl;

//    private List<Partition> partitions;

//    private Addresses addresses;

    @Relationship(type = "HasA",direction = Relationship.INCOMING)
    private List<Partition> partitions;

    @Relationship(type = "LocatedIn",direction = Relationship.INCOMING)
    private List<Area> areas;

    @Override
    public String toString() {
        return "StorageUnit{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", ownerMail='" + ownerMail + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", partitions=" + partitions +
                ", areas=" + areas +
                '}';
    }

}
