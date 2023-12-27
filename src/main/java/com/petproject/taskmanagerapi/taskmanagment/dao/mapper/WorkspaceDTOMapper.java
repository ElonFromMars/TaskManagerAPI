package com.petproject.taskmanagerapi.taskmanagment.dao.mapper;

import com.petproject.taskmanagerapi.taskmanagment.dao.dto.CardTableDTO;
import com.petproject.taskmanagerapi.taskmanagment.dao.dto.WorkspaceDTO;
import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;

import java.util.List;
import java.util.stream.Collectors;

public class WorkspaceDTOMapper {
    public static List<WorkspaceDTO> mapToPostDTOs(List<Workspace> posts) {
        return posts.stream()
                .map(WorkspaceDTOMapper::mapToWorkspaceDto)
                .collect(Collectors.toList());
    }

    public static WorkspaceDTO mapToWorkspaceDto(Workspace workspace) {

        List<CardTable> cardTables = workspace.getCardTables();
        List<CardTableDTO> cardTableDTOs = null;
        if(cardTables != null){
            cardTableDTOs = mapToCardTableDTOs(cardTables);
        }

        return WorkspaceDTO.builder()
                .id(workspace.getId())
                .name(workspace.getName())
                .cardTables(cardTableDTOs)
                .build();
    }

    public static Workspace mapToWorkspace(WorkspaceDTO workspaceDTO) {
        var workspace = new Workspace();
        workspace.setName(workspaceDTO.getName());

        return workspace;
    }

    public static List<CardTableDTO> mapToCardTableDTOs(List<CardTable> cardTables) {
        return cardTables.stream()
                .map(WorkspaceDTOMapper::mapToCardTableDto)
                .collect(Collectors.toList());
    }

    public static CardTableDTO mapToCardTableDto(CardTable workspace) {
        return CardTableDTO.builder()
                .id(workspace.getId())
                .name(workspace.getName())
                .build();
    }
}
