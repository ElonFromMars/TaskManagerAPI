package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import com.petproject.taskmanagerapi.taskmanagment.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository){
        this.tableRepository = tableRepository;
    }
    public List<CardTable> findAll() {
        return tableRepository.findAll();
    }
}
