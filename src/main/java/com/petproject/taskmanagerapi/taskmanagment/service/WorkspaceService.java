package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.repository.WorkspaceRepository;
import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public List<Workspace> getAllWorkspaces(User user) {
        return workspaceRepository.findAllByUserUsername(user.getUsername());
    }

    public Optional<Workspace> addWorkspace(User user, Workspace workspace) {

        workspace.setUser(user);
        workspaceRepository.save(workspace);

        return Optional.of(workspace);
    }

    public Optional<Workspace> findById(Long id) {
        return workspaceRepository.findById(id);
    }
}
