package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService){
        this.workspaceService = workspaceService;
    }

    @CrossOrigin
    @GetMapping("/workspaces")
    List<Workspace> getAll() {
        return workspaceService.findAll();
    }
}
