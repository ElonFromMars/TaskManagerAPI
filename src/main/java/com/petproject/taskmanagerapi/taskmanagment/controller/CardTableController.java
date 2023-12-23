package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import com.petproject.taskmanagerapi.taskmanagment.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardTableController {
    private final TableService tableService;

    @Autowired
    public CardTableController(TableService tableService){
        this.tableService = tableService;
    }

    @CrossOrigin
    @GetMapping("/tables")
    List<CardTable> getAll() {
        return tableService.findAll();
    }
}
