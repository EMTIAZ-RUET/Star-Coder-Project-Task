package com.emtiaz.task.management.dtos;

import com.emtiaz.task.management.enums.UserRole;
import lombok.Data;

@Data

public class UserDto {

    private Long Id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
