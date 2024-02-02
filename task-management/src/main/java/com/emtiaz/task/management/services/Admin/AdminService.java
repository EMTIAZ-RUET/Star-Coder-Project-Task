package com.emtiaz.task.management.services.Admin;

import com.emtiaz.task.management.dtos.TaskDto;

import java.util.List;

public interface AdminService {

    boolean postTask(TaskDto taskDto);

    List<TaskDto> getAllTask();

    void deleteCar(Long carId);

}
