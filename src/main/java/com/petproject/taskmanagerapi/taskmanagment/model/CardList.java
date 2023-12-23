package com.petproject.taskmanagerapi.taskmanagment.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "card_lists" )
public class CardList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "card_list_id", updatable = false, insertable = false)
    private List<Card> tables;
}
