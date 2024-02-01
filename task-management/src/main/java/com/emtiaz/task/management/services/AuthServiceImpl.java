package com.emtiaz.task.management.services;

import com.emtiaz.task.management.dtos.SignupRequest;
import com.emtiaz.task.management.dtos.UserDto;
import com.emtiaz.task.management.entities.User;
import com.emtiaz.task.management.enums.UserRole;
import com.emtiaz.task.management.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService{

     private final UserRepository userRepository;

     @PostConstruct
     public void createAdminAccount()
     {
        User adminAccount =  userRepository.findByUserRole(UserRole.ADMIN);

        if(adminAccount == null)
        {
            User newAdminAccount = new User();
            newAdminAccount.setName("Admin");
            newAdminAccount.setUserRole(UserRole.ADMIN);
            newAdminAccount.setEmail("admin@gmail.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(newAdminAccount);
        }
     }



    @Override
    public UserDto createUser(SignupRequest signupRequest) {

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.USER);
        User createUser =  userRepository.save(user);

        UserDto createUserDto = new UserDto();
        createUserDto.setId(createUser.getId());
        createUserDto.setName(createUser.getName());
        createUserDto.setEmail(createUser.getEmail());
        createUserDto.setPassword(createUser.getPassword());
        createUserDto.setUserRole(createUser.getUserRole());


        return createUserDto;
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
