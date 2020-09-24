package com.example.user_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping({"/", "/index.html", "/home.html"})
    public String index(HttpSession session){
        if(session.getAttribute("loginUser") != null)
            return "dashboard";
        else
            return "users/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "users/dashboard";
    }
}
