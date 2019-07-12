package com.stackroute.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendation {

    private String userMail;
    private long pid;
    private String ownerMail;
    private long sqft;
    private String location;
    private long cost;
}
