package com.petproject.taskmanagerapi.taskmanagment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@jakarta.persistence.Table( name = "card_tables" )
public class CardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "card_table_id", updatable = false, insertable = false)
    private List<CardList> tables;
}
