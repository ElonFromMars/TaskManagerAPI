package com.petproject.taskmanagerapi.taskmanagment.repository;

import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
