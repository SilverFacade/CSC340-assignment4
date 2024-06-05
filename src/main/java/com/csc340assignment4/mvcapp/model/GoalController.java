package com.csc340assignment4.mvcapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    GoalService goalService;

    @GetMapping("/all")
    public String listGoals(Model model) {
        model.addAttribute("goals", goalService.getAllGoals());
        return "goals";
    }

    @GetMapping("/{id}")
    public String getGoalById(@PathVariable("id") int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-detail";
    }

    @PostMapping("/create")
    public String addNewGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/all";
    }

//    @GetMapping("/create")
//    public String addNewGoal(Model model) {
//        model.addAttribute("goal", new Goal());
//        return "goal-form";
//    }

//    @PostMapping
//    public String saveGoal(@ModelAttribute Goal goal) {
//        goalService.saveGoal(goal);
//        return "redirect:/goals";
//    }

    @PostMapping("/update")
    public String updateGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/" + goal.getGoalId();
    }

    @GetMapping("/update/{id}")
    public String editGoalForm(@PathVariable int id, Model model) {
        model.addAttribute("goal", goalService.getGoalById(id));
        return "goal-form";
    }

//    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
//    public String getGoalById(@PathVariable int id, Model model) {
//        model.addAttribute("goal", goalService.getGoalById(id));
//        return "goal-detail";
//    }

    @GetMapping("/delete/{id}")
    public String deleteGoalById(@PathVariable int id) {
        goalService.deleteGoalById(id);
        return "redirect:/goals/all";
    }
}