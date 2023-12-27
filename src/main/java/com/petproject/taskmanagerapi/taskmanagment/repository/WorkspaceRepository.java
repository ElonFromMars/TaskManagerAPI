package com.petproject.taskmanagerapi.taskmanagment.repository;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    List<Workspace> findAllByUserUsername(String username);
}
