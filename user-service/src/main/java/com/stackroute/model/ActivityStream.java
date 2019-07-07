package com.stackroute.model;


import lombok.*;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityStream {

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
