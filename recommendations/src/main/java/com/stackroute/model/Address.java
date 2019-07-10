package com.stackroute.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Document

@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
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

    @Override
    public String toString() {
        return "Address{" +
                "plotNo=" + plotNo +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
