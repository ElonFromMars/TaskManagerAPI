package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.repository.CardRepository;
import com.petproject.taskmanagerapi.taskmanagment.repository.CardTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardTableService {
    private final CardTableRepository cardTableRepository;

    public Optional<CardTable> addCardTable(Workspace workspace, CardTable cardTable) {

        cardTable.setWorkspace(workspace);
        cardTableRepository.save(cardTable);

        return Optional.of(cardTable);
    }
}
