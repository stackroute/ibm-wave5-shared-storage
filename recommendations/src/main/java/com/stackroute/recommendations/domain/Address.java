package com.stackroute.recommendations.domain;


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
public class Address {

@GraphId
    private long id;
    private String area;
    private String city;
    private String state;
    private String country;

}
