package com.stackroute.userservice.model;


import lombok.*;

import javax.persistence.Id;
import java.sql.Timestamp;


//@Entity
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

}
