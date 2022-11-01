package com.example.servingwebcontent.api;

public class ToDoList {

    private long id;
    private String description;
    private boolean complete;

    public ToDoList(long id, String description, boolean complete) {
        this.id = id;
        this.description = description;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }



}
