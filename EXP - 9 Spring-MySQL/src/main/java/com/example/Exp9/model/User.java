package com.giridharan.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dead;
    private String task;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return dead;
    }

    public void setName(String name) {
        this.dead = name;
    }

    public String getEmail() {
        return task;
    }

    public void setEmail(String email) {
        this.task = email;
    }
}
