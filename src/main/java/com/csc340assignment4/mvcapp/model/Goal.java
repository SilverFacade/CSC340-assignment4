package com.csc340assignment4.mvcapp.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goalId;

    private int userId;
    @Nonnull
    private String title;

    private String details;
    private Date targetDate;
    private String status;

//    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
//    private List<Task> tasks;

    public Goal() {
    }

    public Goal(int goalId, int userId, String title, String details, Date targetDate, String status) {
        this.goalId = goalId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;
    }

    // Getters and setters
    public int getGoalId() {
        return goalId;
    }
    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
//    public List<Task> getTasks() {
//        return tasks;
//    }
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }
}
