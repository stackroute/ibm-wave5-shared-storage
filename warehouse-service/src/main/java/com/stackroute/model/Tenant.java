package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    private String tName;

    private String tEmailId;

    private String tMobileNumber;

    private Date startDate;

    private Date lastDate;

}
