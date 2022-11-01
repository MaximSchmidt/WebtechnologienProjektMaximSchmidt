package com.example.servingwebcontent;

import com.example.servingwebcontent.api.ToDoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoListController {

    private List<ToDoList> ToDoLists;

    public ToDoListController(){
        ToDoLists = new ArrayList<>();
        ToDoLists.add(new ToDoList(1,  "Kuchen backen", false ));
        ToDoLists.add(new ToDoList(2,  "Joggen gehen", true ));


    }

    @GetMapping(path = "/api/v1/todolist")
    public ResponseEntity<List<ToDoList>> fetchToDoList(){
        return ResponseEntity.ok(ToDoLists);
    }


}
