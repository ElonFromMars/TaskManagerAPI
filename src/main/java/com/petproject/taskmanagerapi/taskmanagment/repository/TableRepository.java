package com.petproject.taskmanagerapi.taskmanagment.repository;

import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<CardTable, Long> {
}
