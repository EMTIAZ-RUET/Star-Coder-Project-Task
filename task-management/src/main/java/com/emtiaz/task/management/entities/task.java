package com.emtiaz.task.management.entities;


import jakarta.persistence.*;
import lombok.Data;

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
}
