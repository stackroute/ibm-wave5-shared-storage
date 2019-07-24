package com.stackroute.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Document
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    private int id = ThreadLocalRandom.current().nextInt();

    @NotEmpty(message = "first name must not be empty")
    @Size(min = 2, max = 30)
    private String warehouseName;
    @NotEmpty
    @Email(message = "email should be a valid email")
    private String ownerMail;

    @NotEmpty(message = "image must not be empty")
    private String imageUrl;

    private Address address;

//    @NotEmpty
    private List<Partitions> partitions;
    private List<Partition> partition;

    private int totalArea;
    private int totalCost;

    private boolean status;

}
