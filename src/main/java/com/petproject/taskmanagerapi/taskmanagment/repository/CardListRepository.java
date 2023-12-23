package com.petproject.taskmanagerapi.taskmanagment.repository;

import com.petproject.taskmanagerapi.taskmanagment.model.CardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardListRepository extends JpaRepository<CardList, Long> {
}
