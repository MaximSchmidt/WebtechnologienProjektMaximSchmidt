package com.example.servingwebcontent.api;

public class ToDoListCreateRequest {

    private String description;
    private boolean complete;

    public ToDoListCreateRequest(String description, boolean complete) {
        this.description = description;
        this.complete = complete;
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
