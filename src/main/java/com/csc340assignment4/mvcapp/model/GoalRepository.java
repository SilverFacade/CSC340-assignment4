package com.csc340assignment4.mvcapp.model;

import com.csc340assignment4.mvcapp.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Integer> {



}
