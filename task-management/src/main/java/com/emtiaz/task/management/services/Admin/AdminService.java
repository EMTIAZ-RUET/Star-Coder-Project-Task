package com.emtiaz.task.management.services.Admin;

import com.emtiaz.task.management.dtos.TaskDto;

public interface AdminService {

    boolean postTask(TaskDto taskDto);
}
