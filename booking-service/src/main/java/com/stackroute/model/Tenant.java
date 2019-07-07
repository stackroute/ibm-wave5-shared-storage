package com.stackroute.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    private String tenantName;

    private String tenantEmailId;

    private String tenantMobileNo;

    private Date startDate;

    private Date lastDate;


}
