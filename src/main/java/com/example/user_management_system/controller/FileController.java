package com.example.user_management_system.controller;

import com.example.user_management_system.entity.File;
import com.example.user_management_system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping("/files")
    public String showFiles(Model model){
        List<File> files = fileService.findAll();
        model.addAttribute("files", files);

        return "files/list";
    }

    @PostMapping("/files/upload")
    public String uploadFile(@Param(value = "filePath") String filePath){
        return "redirect:/files";
    }
}
