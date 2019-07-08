package com.stackroute.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {

    private String userMail;
    private int pid;
    private String ownerMail;
    private int sqft;
    private String location;
    private double cost;
}
