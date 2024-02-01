package com.emtiaz.task.management.dtos;

import com.emtiaz.task.management.enums.UserRole;
import lombok.Data;

@Data

public class AuthenticationResponse {

    private String jwt;
    private UserRole userRole;
    private Long userId;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public Long getUserId() {
        return userId;
    }
}
