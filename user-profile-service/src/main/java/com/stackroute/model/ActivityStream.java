package com.stackroute.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


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

    private List<ListedStorageUnit> ListedStorageUnit = new ArrayList<>();

    private List<BookedStorageUnit> BookedStorageUnit = new ArrayList<>();

    @Override
    public String toString() {
        return "ActivityStream{" +
                "role='" + role + '\'' +
                ", timeStamp=" + timeStamp +
                ", emailId='" + emailId + '\'' +
                ", ListedStorageUnit=" + ListedStorageUnit +
                ", BookedStorageUnit=" + BookedStorageUnit +
                '}';
    }
}
