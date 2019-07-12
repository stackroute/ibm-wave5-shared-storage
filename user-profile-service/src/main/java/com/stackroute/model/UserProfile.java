package com.stackroute.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class UserProfile {

    private String role;

    private Date timeStamp;

    @Id
    private String emailId;

    private List<ListedStorageUnit> ListedStorageUnit = new ArrayList<>();

    private List<BookedStorageUnit> BookedStorageUnit = new ArrayList<>();

    @Override
    public String toString() {
        return "UserProfile{" +
                "role='" + role + '\'' +
                ", timeStamp=" + timeStamp +
                ", emailId='" + emailId + '\'' +
                ", ListedStorageUnit=" + ListedStorageUnit +
                ", BookedStorageUnit=" + BookedStorageUnit +
                '}';
    }
}
