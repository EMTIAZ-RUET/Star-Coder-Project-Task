package com.emtiaz.task.management.services.Admin;

import com.emtiaz.task.management.dtos.TaskDto;
import com.emtiaz.task.management.entities.task;
import com.emtiaz.task.management.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @Override
    public List<TaskDto> getAllTask() {
        return taskRepository.findAll().stream().map(task::getTaskDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTask(Long taskId) {

        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDto getTaskById(long taskId) {

        Optional<task> optionalCar = taskRepository.findById(taskId);

        return optionalCar.map(task::getTaskDto).orElse(null);

    }

}
