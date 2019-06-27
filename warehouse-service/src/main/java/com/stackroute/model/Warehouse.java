package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    private int id;

    @NotEmpty(message = "first name must not be empty")
    @Size(min = 2, max = 30)
    private String name;
    @NotEmpty(message = "image must not be empty")
    private String image_url;
    @NotEmpty
    //@Email(message = "email should be a valid email")
    private String owner_mailid;
    @NotEmpty
    private String time_stamp;
    @NotEmpty
    private List<Partition> partitions;
    @NotEmpty(message = "location must not be empty")
    private String location;

    private Address address;
    @NotEmpty
    private String occupied_partitions;
    @NotEmpty(message = "please mention the square feet")
    private String total_sqft;
}
