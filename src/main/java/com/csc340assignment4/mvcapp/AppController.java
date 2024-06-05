package com.csc340assignment4.mvcapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "/index"})
    public String home(){
        return "redirect:/goals/all";
    }

}
