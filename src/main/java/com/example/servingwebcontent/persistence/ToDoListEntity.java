package com.example.servingwebcontent.persistence;

import javax.persistence.*;
import java.time.LocalDate;


@Entity( name = "ToDoList")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column(name = "titel", nullable = false)
    private String titel;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "complete")
    private Boolean complete;

    @Column(name = "priority")
    private Boolean priority;

    public ToDoListEntity(String titel, String description, String category, LocalDate date, Boolean complete, Boolean priority) {
        this.titel = titel;
        this.description = description;
        this.category = category;
        this.date = date;
        this.complete = complete;
        this.priority = priority;
    }

    protected ToDoListEntity() {

    }

    public Long getId() {
        return id;
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
