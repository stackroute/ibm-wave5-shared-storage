package com.stackroute.userservice.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private static final long serialVersionUID = 4865903039190150223L;

    @Size(min = 3)
    private String firstName;

    @Size(min = 3)
    private String lastName;

    @NotEmpty(message = "mobile number is invalid")
    private String mobileNo;

    @NotNull
    private String emailId;
  
    private String password;

    private String role;
}
