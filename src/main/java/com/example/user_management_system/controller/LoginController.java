package com.example.user_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpSession session){
        if(session.getAttribute("loginUser") == null)
            return "users/login";
        else
            return "dashboard";
    }

    @GetMapping("/signOut")
    public String signOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "users/login";
    }

    @PostMapping("/login")
    public String login_handler(@RequestParam("username") String username, @RequestParam("password") String password,
                                Map<String, Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser", username);
            return "dashboard";
        }
        else{
            map.put("errorMessage", "请输入正确的用户名或密码");
            return "users/login";
        }
    }
}
