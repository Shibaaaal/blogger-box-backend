package com.dauphine.blocker;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

public class Post {

    private String name;
    private String description;
    private UUID id;
    private DateTimeFormat date;
    private UUID categoryId;

    public Post(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DateTimeFormat getDate() {
        return date;
    }

    public void setDate(DateTimeFormat date) {
        this.date = date;
    }

    public UUID getCategoryId() {
        return categoryId;
    }
}
