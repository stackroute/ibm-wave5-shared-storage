package com.stackroute.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListedStorageUnit {

    @Id
    private String emailId;
    private String name;

    @Override
    public String toString() {
        return "ListedStorageUnit{" +
                "emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", occupiedPartition='" + occupiedPartition + '\'' +
                ", totalPartition='" + totalPartition + '\'' +
                ", address=" + address +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    private int id;
    private String occupiedPartition;
    private String totalPartition;
    private Address address;
    private String imageUrl;
}
