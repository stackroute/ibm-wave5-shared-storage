package com.stackroute.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.sql.Timestamp;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ActivityStream{

    private String role;

    private Timestamp timeStamp;

    @Id
    private String emailId;

    @Override
    public String toString() {
        return "ActivityStream{" +
                "role='" + role + '\'' +
                ", timeStamp=" + timeStamp +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
