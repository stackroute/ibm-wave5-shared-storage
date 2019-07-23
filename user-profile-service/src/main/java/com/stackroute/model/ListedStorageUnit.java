package com.stackroute.model;

import lombok.*;
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

    @Override
    public String toString() {
        return "ListedStorageUnit{" +
                "emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", address=" + address +
                ", occupiedPartition='" + occupiedPartition + '\'' +
                ", totalPartition='" + totalPartition + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    private int id;
    private Address address;
    private String occupiedPartition;
    private String totalPartition;
    private String imageUrl;
}