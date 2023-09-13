package com.project.TaskUnity.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Column(name = "task_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int taskId;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "due_date")
    public String due_date;

    @Column(name = "status")
    public int status;

    @Column(name = "project_id")
    public int projectId;

    @Column(name = "priority")
    public String priority;

    public Task() {
    }

    public Task(String title, String description, String due_date, int status, String priority) {
        this.title = title;
        this.description = description;
        this.due_date = due_date;
        this.status = status;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", due_date='" + due_date + '\'' +
                ", status=" + status +
                ", priority='" + priority + '\'' +
                '}';
    }
}

