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

public class Address {

    @NotEmpty
    private int plotNo;

    @NotEmpty
    private String area;

    @NotEmpty
    private String city;

    private String state;

    private String country;

    @NotEmpty
    private int pincode;


}
