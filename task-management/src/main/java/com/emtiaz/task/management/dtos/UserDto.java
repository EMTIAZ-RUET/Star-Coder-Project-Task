package com.emtiaz.task.management.dtos;

import com.emtiaz.task.management.enums.UserRole;
import lombok.Data;

@Data

public class UserDto {

    private Long Id;

    private String name;

    private String email;

    private String password;

    private UserRole userrole;


}
