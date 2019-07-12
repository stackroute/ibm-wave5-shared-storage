package com.stackroute.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partition {

//    @GraphId
    private long id;

//    @Property
    private long pid;
    private long sqft;
    private long cost;

}
