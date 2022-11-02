package com.example.servingwebcontent.persistence;

import javax.persistence.*;


@Entity( name = "ToDoList")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column( name = "description", nullable = false)
    private String description;

    @Column( name = "complete")
    private Boolean complete;


    public ToDoListEntity(String description, Boolean complete) {
        this.description = description;
        this.complete = complete;
    }

    protected ToDoListEntity() {

    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}



