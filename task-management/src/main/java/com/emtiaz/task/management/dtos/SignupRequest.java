package com.emtiaz.task.management.dtos;

import lombok.Data;

@Data

public class SignupRequest {

    private String email;
    private String name;

    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
