package com.example.user_management_system.controller;

import com.example.user_management_system.dao.UserDao;
import com.example.user_management_system.entity.User;
import com.example.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(HttpSession session){
        if(session.getAttribute("loginUser") == null)
            return "users/login";
        else
            return "dashboard";
    }

    @GetMapping("/signOut")
    public String signOut(Map<String, Object> map, HttpSession session){
        map.put("logout", "您已成功登出");
        session.removeAttribute("loginUser");
        return "users/login";
    }

    @PostMapping("/login")
    public String login_handler(@RequestParam("username") String username, @RequestParam("password") String password,
                                Map<String, Object> map, HttpSession session){
        User user = userService.findUserByUsername(username);
        System.out.println(user);

        if(user != null && user.getPassword().equals(password)){
            session.setAttribute("loginUser", username);
            return "dashboard";
        }
        else{
            map.put("errorMessage", "请输入正确的用户名或密码");
            return "users/login";
        }
    }
}
