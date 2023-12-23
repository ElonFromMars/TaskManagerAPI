package com.petproject.taskmanagerapi.taskmanagment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@jakarta.persistence.Table( name = "workspaces" )
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "workspace_id", updatable = false, insertable = false)
    private List<CardTable> cardTables;
}
