package com.syte.syte.Model.Entity;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class User_options {
    @NotEmpty(message = "Username must not be empty")
    private String username;
    @NotEmpty(message = "Password must not be empty")
    private String password;
    private String country;
    private String email;
    private String telephone_number;
}
