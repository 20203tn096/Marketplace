package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.status.model.Status;

public class CategoryDTO { //Data Transfer Object  medio de comunicación entre nuestra vista y controlador
    private long id;
    private String description;
    private Status status;

    public CategoryDTO() {
    }

    public CategoryDTO(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public CategoryDTO(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
