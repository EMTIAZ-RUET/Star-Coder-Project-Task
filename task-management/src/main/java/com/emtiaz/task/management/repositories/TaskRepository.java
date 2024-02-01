package com.emtiaz.task.management.repositories;

import com.emtiaz.task.management.entities.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TaskRepository extends JpaRepository<task,Long> {
}
