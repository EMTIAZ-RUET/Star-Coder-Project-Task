package com.emtiaz.task.management.dtos;

import lombok.Data;

@Data

public class AuthenticationRequest
{
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
