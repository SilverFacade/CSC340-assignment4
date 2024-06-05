package com.csc340assignment4.mvcapp.model;

import com.csc340assignment4.mvcapp.model.Goal;
import com.csc340assignment4.mvcapp.model.Task;
import com.csc340assignment4.mvcapp.model.GoalService;
import com.csc340assignment4.mvcapp.model.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private GoalService goalService;

    @GetMapping("/{id}")
    public String viewTask(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/new/{goalId}")
    public String newTaskForm(@PathVariable("goalId") int goalId, Model model) {
        Task task = new Task();
        Goal goal = goalService.getGoalById(goalId);
        task.setGoal(goal);
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/goals/" + task.getGoal().getGoalId();
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") int id, @ModelAttribute Task task) {
        task.setTaskId(id);
        taskService.saveTask(task);
        return "redirect:/goals/" + task.getGoal().getGoalId();
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        Task task = taskService.getTaskById(id);
        taskService.deleteTask(id);
        return "redirect:/goals/" + task.getGoal().getGoalId();
    }
}
