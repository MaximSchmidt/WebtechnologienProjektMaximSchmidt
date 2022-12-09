package com.example.servingwebcontent.api;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ToDoListManipulationRequest {

    @Size(min = 1, message = "Beschreibe deinen Titel mit mindestens 1 Buchstaben")
    private String titel;
    @NotBlank(message = "Beschreibe deine Aufgabe")
    private String description;
    @NotBlank(message = "Wähle eine Kategorie")
    private String category;
    @FutureOrPresent(message = "Wähle eine Deadline für deine Aufgabe")
    private LocalDate date;
    private Boolean complete;
    private Boolean priority;

    public ToDoListManipulationRequest(String titel, String description, String category, LocalDate date, Boolean complete, Boolean priority) {
        this.titel = titel;
        this.description = description;
        this.category = category;
        this.date = date;
        this.complete = complete;
        this.priority = priority;
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
