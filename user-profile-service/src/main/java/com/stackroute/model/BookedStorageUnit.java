package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
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