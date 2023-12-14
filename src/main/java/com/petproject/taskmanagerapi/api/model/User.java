package com.petproject.taskmanagerapi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "USERS" )
public class User {

    @Id
    private int id;
    private String name;
    private String email;
}
