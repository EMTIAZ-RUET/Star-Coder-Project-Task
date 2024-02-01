package com.emtiaz.task.management.services;

import com.emtiaz.task.management.dtos.SignupRequest;
import com.emtiaz.task.management.dtos.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
