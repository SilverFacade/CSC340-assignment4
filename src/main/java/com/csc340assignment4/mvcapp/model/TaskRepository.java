package com.csc340assignment4.mvcapp.model;

import com.csc340assignment4.mvcapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {



}