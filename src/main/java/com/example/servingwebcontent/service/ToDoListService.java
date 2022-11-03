package com.example.servingwebcontent.service;

import com.example.servingwebcontent.api.ToDoList;
import com.example.servingwebcontent.api.ToDoListCreateRequest;
import com.example.servingwebcontent.persistence.ToDoListEntity;
import com.example.servingwebcontent.persistence.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {


    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }


    public List<ToDoList> findAll() {
        List<ToDoListEntity> todoList = toDoListRepository.findAll();
        return todoList.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public ToDoList create(ToDoListCreateRequest request) {
        var todolistEntity = new ToDoListEntity(request.getDescription(), request.isComplete());
        todolistEntity = toDoListRepository.save(todolistEntity);
        return transformEntity(todolistEntity);
    }

    public ToDoList transformEntity(ToDoListEntity todolistEntity) {
        return new ToDoList(
                todolistEntity.getId(),
                todolistEntity.getDescription(),
                todolistEntity.getComplete()
        );
    }

}
