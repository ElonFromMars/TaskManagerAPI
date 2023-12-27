package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.dao.dto.WorkspaceDTO;
import com.petproject.taskmanagerapi.taskmanagment.dao.mapper.WorkspaceDTOMapper;
import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.service.WorkspaceService;
import com.petproject.taskmanagerapi.user.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user/{username}")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService){
        this.workspaceService = workspaceService;
    }

    @GetMapping("/workspaces")
    ResponseEntity<List<WorkspaceDTO>> getAllWorkspaces(@PathVariable String username, UserPrincipal principal)
    {
        if (principal == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        var list = workspaceService.getAllWorkspaces(username).stream().map(WorkspaceDTOMapper::mapToWorkspaceDto).toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/workspaces")
    ResponseEntity<WorkspaceDTO> createWorkspace(@PathVariable String username, @RequestBody WorkspaceDTO workspaceDTO)
    {
        /*
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().getId() != userID) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        */
        Optional<Workspace> workspace = workspaceService.addWorkspace(WorkspaceDTOMapper.mapToWorkspace(workspaceDTO), username);

        if(workspace.isPresent()){
            return ResponseEntity.ok(WorkspaceDTOMapper.mapToWorkspaceDto(workspace.get()));
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
