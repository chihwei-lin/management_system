package com.example.user_management_system.controller;

import com.example.user_management_system.entity.User;
import com.example.user_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String listAllUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "users/list";
    }

    @GetMapping("/users/search")
    public String search(@RequestParam("id") Integer id, Model model){
        Optional<User> user = userService.findById(id);

        if(user.isEmpty()){
            model.addAttribute("errorMessage", "该用户不存在");

            List<User> departments = userService.findAll();
            model.addAttribute("departments", departments);

            return "departments/list";
        }
        model.addAttribute("user", user.get());

        return "users/add";
    }

    @GetMapping("/user")
    public String toAddPage(){
        return "users/add";
    }

    @PostMapping("/user")
    public String add(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);

        return "users/add";
    }

    @PutMapping("/user")
    public String edit(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }
}
