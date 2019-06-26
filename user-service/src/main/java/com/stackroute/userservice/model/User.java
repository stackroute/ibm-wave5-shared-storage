package com.stackroute.userservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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

    private static final long serialVersionUID = 4865903039190150223L;

    @NotNull
    private int id;
    @Size(min = 3)
    private String firstName;
    @Size(min = 3)
    private String lastName;
    @Size(min = 10)
    private String mobileNo;
    @Id
    private String emailId;
    private String password;
    private String role;
}
