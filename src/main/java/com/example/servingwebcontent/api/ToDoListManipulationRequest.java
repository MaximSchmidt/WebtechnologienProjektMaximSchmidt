package com.example.servingwebcontent.api;

public class ToDoListManipulationRequest {

    private String description;
    private boolean complete;

    public ToDoListManipulationRequest(String description, boolean complete) {
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
