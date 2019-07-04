package com.stackroute.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


//@Entity
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
    private int id;
    private String occupiedPartition;
    private String totalPartition;
    private Address address;
}
