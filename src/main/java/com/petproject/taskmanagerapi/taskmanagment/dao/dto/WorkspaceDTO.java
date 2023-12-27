package com.petproject.taskmanagerapi.taskmanagment.dao.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WorkspaceDTO {
    private Long id;
    private String name;
    private List<CardTableDTO> cardTables;
}
