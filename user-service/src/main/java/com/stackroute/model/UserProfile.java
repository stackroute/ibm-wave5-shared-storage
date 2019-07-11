package com.stackroute.model;


import lombok.*;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
