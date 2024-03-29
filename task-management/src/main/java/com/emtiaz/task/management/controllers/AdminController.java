package com.emtiaz.task.management.controllers;


import com.emtiaz.task.management.dtos.TaskDto;
import com.emtiaz.task.management.services.Admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/tasks")

    public  ResponseEntity<List<TaskDto>>getAllTask()
    {
         List<TaskDto>taskDtoList = adminService.getAllTask();

         return ResponseEntity.ok(taskDtoList);
    }

    @DeleteMapping("/task/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId)
    {
       adminService.deleteTask(taskId);

       return ResponseEntity.noContent().build();
    }

    public ResponseEntity<TaskDto>getPostById(@PathVariable Long taskId)
    {
         TaskDto taskDto = adminService.getTaskById(taskId);

         if(taskDto !=null )
             return ResponseEntity.ok(taskDto);

         return ResponseEntity.notFound().build();
    }

}
