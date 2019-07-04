package com.stackroute.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookedStorageUnit {

    private int id;
    @Id
    private String emailId;
    private String name;
    private String location;
    private int sqft;
    private Date startDate;
    private Date endDate;
}