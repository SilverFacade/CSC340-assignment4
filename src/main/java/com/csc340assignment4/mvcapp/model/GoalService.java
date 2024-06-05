package com.csc340assignment4.mvcapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(int goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    public void addNewGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public void deleteGoalById(int goalId) {
        goalRepository.deleteById(goalId);
    }
}
