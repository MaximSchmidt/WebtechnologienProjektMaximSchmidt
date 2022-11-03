package com.example.servingwebcontent.service;

import com.example.servingwebcontent.api.ToDoList;
import com.example.servingwebcontent.api.ToDoListManipulationRequest;
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

    public ToDoList findById(Long id){
        var todolistEntity = toDoListRepository.findById(id);
        return todolistEntity.map(this::transformEntity).orElse(null);
    }

    public ToDoList create(ToDoListManipulationRequest request) {
        var todolistEntity = new ToDoListEntity(request.getDescription(), request.isComplete());
        todolistEntity = toDoListRepository.save(todolistEntity);
        return transformEntity(todolistEntity);
    }

    public ToDoList update(Long id, ToDoListManipulationRequest request) {
        var todolistEntityOptional = toDoListRepository.findById(id);
        if (todolistEntityOptional.isEmpty()) {
            return null;
        }
        var todolistEntity = todolistEntityOptional.get();
        todolistEntity.setComplete(request.isComplete());
        todolistEntity.setDescription(request.getDescription());
        todolistEntity = toDoListRepository.save(todolistEntity);


        return transformEntity(todolistEntity);
    }


    public boolean deleteById(Long id) {
        if(!toDoListRepository.existsById(id)){
        return false;
        }

        toDoListRepository.deleteById(id);
        return true;

    }




    public ToDoList transformEntity(ToDoListEntity todolistEntity) {
        return new ToDoList(
                todolistEntity.getId(),
                todolistEntity.getDescription(),
                todolistEntity.getComplete()
        );
    }

}
