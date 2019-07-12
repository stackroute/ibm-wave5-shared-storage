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
public class History {
    

    @Id
    private BookingIdentity bookingIdentity;
    private String userName;
    private String userMailId;
    private String userMobile;
    private String ownerMail;
    private int sqft;
    private String location;
    private Date startDate;
    private Date endDate;
    private long cost;
    private double totalCost;

}
