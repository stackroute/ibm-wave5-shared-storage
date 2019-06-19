package com.stackroute.LoginService.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private int id;
    private String name;
    private String mobileNo;
    private String emailId;
    private String password;
    private String aadharNo;
}
