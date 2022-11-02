package com.example.servingwebcontent.persistence;

import javax.persistence.*;

public class ToDoListEntity {

@Entity( name = "ToDoList")
    public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;

    @Column( name = "description", nullable = false)
    private String description;

    @Column( name = "complete")
    private boolean complete;


    public PersonEntity(String description, boolean complete) {
        this.description = description;
        this.complete = complete;
    }

    protected PersonEntity() {

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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}


}
