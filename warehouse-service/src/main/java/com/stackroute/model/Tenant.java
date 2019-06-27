package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {

    private String name;

    private String emailId;

    private String mobileNumber;

    private String startDate;

    private String lastDate;

}
