package com.stackroute.model;

import lombok.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {



    private int id;



    private static final long serialVersionUID = 4865903039190150223L;
    @Size(min = 3)
    private String firstName;
    @Size(min = 1)
    private String lastName;


    @Size(min = 10)
    private String mobileNo;

    @NotNull
    private String emailId;
    private String password;
    private String role;
}
