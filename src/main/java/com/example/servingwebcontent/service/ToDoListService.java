package com.example.servingwebcontent.service;

import com.example.servingwebcontent.api.ToDoList;
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
                .map(ToDoListEntity -> new ToDoList(
                        ToDoListEntity.getId(),
                        ToDoListEntity.getDescription(),
                        ToDoListEntity.getComplete()
                ))
                .collect(Collectors.toList());
    }

}
