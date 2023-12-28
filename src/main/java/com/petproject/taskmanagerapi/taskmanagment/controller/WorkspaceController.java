package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.dao.dto.WorkspaceDTO;
import com.petproject.taskmanagerapi.taskmanagment.dao.mapper.WorkspaceDTOMapper;
import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.service.WorkspaceService;
import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.security.UserPrincipal;
import com.petproject.taskmanagerapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user/{username}")
public class WorkspaceController {
    private final WorkspaceService workspaceService;
    private final UserService userService;

    @GetMapping("/workspaces")
    ResponseEntity<List<WorkspaceDTO>> getAllWorkspaces(@PathVariable String username, UserPrincipal principal)
    {
        if (principal == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Optional<User> user = userService.findByUsername(username);

        if (user.isPresent()){
            var list = workspaceService.getAllWorkspaces(user.get()).stream().map(WorkspaceDTOMapper::mapToWorkspaceDto).toList();

            return ResponseEntity.ok(list);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/workspaces")
    ResponseEntity<WorkspaceDTO> createWorkspace(@PathVariable String username, @RequestBody WorkspaceDTO workspaceDTO)
    {
        /*
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().getId() != userID) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        */
        Optional<User> user = userService.findByUsername(username);

        if (user.isPresent()){
            Workspace workspace = WorkspaceDTOMapper.mapToWorkspace(workspaceDTO);
            Optional<Workspace> resultWorkspace = workspaceService.addWorkspace(user.get(), workspace);

            if (resultWorkspace.isPresent()){
                return ResponseEntity.ok(WorkspaceDTOMapper.mapToWorkspaceDto(resultWorkspace.get()));
            }
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
