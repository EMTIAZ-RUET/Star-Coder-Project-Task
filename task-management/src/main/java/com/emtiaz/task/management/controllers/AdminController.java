package com.emtiaz.task.management.controllers;


import com.emtiaz.task.management.dtos.TaskDto;
import com.emtiaz.task.management.services.Admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/task")

    public ResponseEntity<?> postTask(@ModelAttribute TaskDto taskDto)
    {
       boolean success =  adminService.postTask(taskDto);

       if(success)
           return ResponseEntity.status(HttpStatus.CREATED).build();

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}