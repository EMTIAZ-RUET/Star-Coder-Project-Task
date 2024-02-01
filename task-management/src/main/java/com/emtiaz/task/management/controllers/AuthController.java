package com.emtiaz.task.management.controllers;


import com.emtiaz.task.management.dtos.SignupRequest;
import com.emtiaz.task.management.dtos.UserDto;
import com.emtiaz.task.management.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class AuthController {

    private final AuthService authService;




    @PostMapping("/register")
    public ResponseEntity<?>createUser(@RequestBody SignupRequest signupRequest)
    {
        if(authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email Already Exist. Try again With another email");

          UserDto createdUserDto = authService.createUser(signupRequest);

          if(createdUserDto == null)
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request !");

          return  ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
    }
}
