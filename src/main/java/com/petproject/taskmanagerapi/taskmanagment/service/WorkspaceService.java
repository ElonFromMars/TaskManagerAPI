package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository){
        this.workspaceRepository = workspaceRepository;
    }
    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }
}
