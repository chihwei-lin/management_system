package com.example.user_management_system.controller;

import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class ProductController {
    @Autowired
    ProductDao productDao;

    @GetMapping("/products")
    public String list(Model model){
        Collection<Product> products = productDao.getAll();
        model.addAttribute("products", products);

        return "products/list";
    }

    @GetMapping("/product")
    public String toAddPage(){
        return "products/add";
    }

    @PostMapping("/product")
    public String add(Product product){
        productDao.add(product);

        return "redirect:/products";
    }
}
