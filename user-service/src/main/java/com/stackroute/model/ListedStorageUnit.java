package com.stackroute.model;

import lombok.*;
import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@Data
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
                ", addresses=" + address +
                ", occupiedPartition='" + occupiedPartition + '\'' +
                ", totalPartition='" + totalPartition + '\'' +
                '}';
    }

    private int id;
    private Address address;
    private String occupiedPartition;
    private String totalPartition;
}