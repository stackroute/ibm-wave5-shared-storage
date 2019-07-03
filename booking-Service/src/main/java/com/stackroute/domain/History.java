package com.stackroute.domain;

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
    public int warehouseId;
    public String userName;
    public String userMailId;
    public String userMobile;
    public String ownerMail;
    public int pid;
    public int sqft;
    private String location;
    public Date startDate;
    public Date endDate;
    public double cost;
    public double totalCost;
}
