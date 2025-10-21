package com.example.tasktracker.model;

public class Task {
    String task;
    String owner;

    public Task(){

    }
    public Task(String owner, String task) {
        this.owner = owner;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
