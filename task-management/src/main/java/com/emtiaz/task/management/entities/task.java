package com.emtiaz.task.management.entities;


import com.emtiaz.task.management.dtos.TaskDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.scheduling.config.Task;

@Entity
@Data
@Table(name="tasks")

public class task {

     @jakarta.persistence.Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String type;

    private String descripton;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }


    public TaskDto getTaskDto()
    {
        TaskDto taskDto = new TaskDto();

        taskDto.setDescripton(descripton);
        taskDto.setId(Id);
        taskDto.setName(name);
        taskDto.setType(type);

        return taskDto;
    }
    
    
}
