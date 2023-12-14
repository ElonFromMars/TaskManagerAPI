package com.petproject.taskmanagerapi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "TASKS" )
public class Task {
    @Id
    private int id;
    private String text;
    private boolean done;
}
