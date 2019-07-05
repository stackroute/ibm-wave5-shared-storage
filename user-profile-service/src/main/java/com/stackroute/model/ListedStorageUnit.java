package com.stackroute.model;

import lombok.*;
import org.apache.tomcat.jni.Address;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListedStorageUnit{

    @Id
    private String emailId;
    private String name;
    private int id;
    private Address address;
    private String occupiedPartition;
    private String totalPartition;
}