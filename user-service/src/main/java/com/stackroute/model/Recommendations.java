package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recommendations {

    private String name;

    private String mobileNo;

    private String emailId;

    private String role;
}
