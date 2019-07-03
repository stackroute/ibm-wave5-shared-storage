package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListedStorageUnit{

    @Id
    private String emailId;
    private String name;
    private int id ;
    private String location;
    private String occupiedPartition;
    private String totalPartition;

}