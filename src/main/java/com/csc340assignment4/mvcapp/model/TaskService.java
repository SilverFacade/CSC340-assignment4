package com.csc340assignment4.mvcapp.model;

import com.csc340assignment4.mvcapp.model.Task;
import com.csc340assignment4.mvcapp.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }
}
