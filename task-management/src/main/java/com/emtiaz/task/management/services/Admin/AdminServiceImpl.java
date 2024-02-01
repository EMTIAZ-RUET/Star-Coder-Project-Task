package com.emtiaz.task.management.services.Admin;

import com.emtiaz.task.management.dtos.TaskDto;
import com.emtiaz.task.management.entities.task;
import com.emtiaz.task.management.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class AdminServiceImpl implements  AdminService {

    private final TaskRepository taskRepository;


    @Override
    public boolean postTask(TaskDto taskDto) {

        try {
            task taskk = new task();
            taskk.setName(taskDto.getName());
            taskk.setDescripton(taskDto.getDescripton());
            taskk.setId(taskDto.getId());
            taskk.setType(taskDto.getType());
        } catch (Exception e) {
            return false;
        }

        return false;
    }

}
