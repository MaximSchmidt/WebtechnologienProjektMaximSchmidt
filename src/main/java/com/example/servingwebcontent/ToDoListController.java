package com.example.servingwebcontent;

import com.example.servingwebcontent.api.ToDoList;
import com.example.servingwebcontent.persistence.ToDoListRepository;
import com.example.servingwebcontent.service.ToDoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoListController {

    private final ToDoListService ToDoListService;

    public ToDoListController(com.example.servingwebcontent.service.ToDoListService toDoListService) {
        ToDoListService = toDoListService;
    }

    @GetMapping(path = "/api/v1/todolist")
    public ResponseEntity<List<ToDoList>> fetchToDoList(){
        return ResponseEntity.ok(ToDoListService.findAll());
    }


}
