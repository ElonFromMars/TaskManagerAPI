package com.petproject.taskmanagerapi.taskmanagment.service;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.repository.WorkspaceRepository;
import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    private final UserRepository userRepository;

    public List<Workspace> getAllWorkspaces(String username) {
        return workspaceRepository.findAllByUserUsername(username);
    }

    public Optional<Workspace> addWorkspace(Workspace workspace, String username) {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            workspace.setUser(user.get());
            workspaceRepository.save(workspace);
            return Optional.of(workspace);
        }
        return Optional.empty();
    }
}
