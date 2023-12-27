package com.petproject.taskmanagerapi.taskmanagment.dao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardTableDTO {
    private Long id;
    private String name;
    //TODO
    //private List<CardList> tables;
}
