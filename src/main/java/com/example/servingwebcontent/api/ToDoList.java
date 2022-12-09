package com.example.servingwebcontent.api;

import java.time.LocalDate;

public class ToDoList {

    private long id;
    private String titel;
    private String description;
    private String category;
    private LocalDate date;
    private Boolean complete;
    private Boolean priority;

    public ToDoList(long id, String titel, String description, String category, LocalDate date, Boolean complete, Boolean priority) {
        this.id = id;
        this.titel = titel;
        this.description = description;
        this.category = category;
        this.date = date;
        this.complete = complete;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }
}
