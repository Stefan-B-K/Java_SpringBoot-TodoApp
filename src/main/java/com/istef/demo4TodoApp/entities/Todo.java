package com.istef.demo4TodoApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String task;

    @NotNull
    @Future
    private LocalDate dueDate;

    private Boolean done = false;

    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate schedule) {
        this.dueDate = schedule;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", task='" + task + '\'' +
                ", schedule=" + dueDate +
                ", done=" + done +
                '}';
    }
}
