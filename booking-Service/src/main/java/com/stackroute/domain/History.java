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
    public String customer_name;
    public String customerMailId;
    public String customer_mobilenumber;
    public String ownerMail;
    public int partitionId;
    public Date start_date;
    public Date end_date;
    public double cost;
    public double total_cost;
}
