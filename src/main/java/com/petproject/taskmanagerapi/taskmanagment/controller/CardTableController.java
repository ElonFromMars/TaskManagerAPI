package com.petproject.taskmanagerapi.taskmanagment.controller;

import com.petproject.taskmanagerapi.taskmanagment.dao.dto.CardTableDTO;
import com.petproject.taskmanagerapi.taskmanagment.dao.dto.WorkspaceDTO;
import com.petproject.taskmanagerapi.taskmanagment.dao.mapper.WorkspaceDTOMapper;
import com.petproject.taskmanagerapi.taskmanagment.model.CardTable;
import com.petproject.taskmanagerapi.taskmanagment.model.Workspace;
import com.petproject.taskmanagerapi.taskmanagment.service.CardTableService;
import com.petproject.taskmanagerapi.taskmanagment.service.WorkspaceService;
import com.petproject.taskmanagerapi.user.model.User;
import com.petproject.taskmanagerapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user/{username}")
public class CardTableController {
    private final CardTableService cardTableService;
    private final WorkspaceService workspaceService;
    private final UserService userService;

    @PostMapping("/workspaces/{workspaceId}/tables")
    ResponseEntity<CardTableDTO> createTable(@PathVariable String username, @PathVariable Long workspaceId, @RequestBody CardTableDTO cardTableDTO)
    {
        /*
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().getId() != userID) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        */

        Optional<User> userResult = userService.findByUsername(username);
        if (userResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Optional<Workspace> workspaceResult = workspaceService.findById(workspaceId);
        if (workspaceResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Workspace workspace = workspaceResult.get();

        CardTable cardTable = WorkspaceDTOMapper.mapToCardTable(cardTableDTO);
        Optional<CardTable> resultCardTable = cardTableService.addCardTable(workspace, cardTable);

        if (resultCardTable.isPresent()){
            return ResponseEntity.ok(WorkspaceDTOMapper.mapToCardTableDto(resultCardTable.get()));
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
