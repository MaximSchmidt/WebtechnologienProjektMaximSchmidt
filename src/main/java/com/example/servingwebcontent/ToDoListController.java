package com.example.servingwebcontent;

import com.example.servingwebcontent.api.ToDoList;
import com.example.servingwebcontent.api.ToDoListManipulationRequest;
import com.example.servingwebcontent.service.ToDoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ToDoListController {

    private final ToDoListService ToDoListService;

    public ToDoListController(com.example.servingwebcontent.service.ToDoListService toDoListService) {
        ToDoListService = toDoListService;
    }

    @GetMapping(path = "/api/v1/todolist")
    public ResponseEntity<List<ToDoList>> fetchToDoList(){return ResponseEntity.ok(ToDoListService.findAll());
    }

    @GetMapping(path = "/api/v1/todolist/{id}")
    public ResponseEntity<ToDoList> fetchToDoListByID(@PathVariable Long id){
        var todolist =  ToDoListService.findById(id);
        return todolist !=null? ResponseEntity.ok(todolist) : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/todolist")
    public ResponseEntity<Void> creatToDoList(@RequestBody ToDoListManipulationRequest request) throws URISyntaxException {
        var ToDoList   = ToDoListService.create(request);
        URI uri = new URI("/api/v1/todolist" + ToDoList.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/todolist/{id}")
    public ResponseEntity<ToDoList> updateToDoList(@PathVariable Long id, @RequestBody ToDoListManipulationRequest request){
        var todolist =  ToDoListService.update(id, request);
        return todolist !=null? ResponseEntity.ok(todolist) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/todolist/{id}")
    public ResponseEntity<Void> deleteToDoList(@PathVariable Long id){
        boolean successful =  ToDoListService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }



}
