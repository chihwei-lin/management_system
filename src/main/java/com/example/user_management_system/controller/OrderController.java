package com.example.user_management_system.controller;

import com.example.user_management_system.dao.OrderDao;
import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Order;
import com.example.user_management_system.model.Product;
import com.example.user_management_system.service.OrderService;
import com.example.user_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping("/orders")
    public String list(Model model){
        Collection<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "orders/list";
    }

    @GetMapping("/order")
    public String toAddPage(Model model){
        Collection<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "orders/add";
    }

    @PostMapping("/order")
    public String add(Order order){
        orderService.save(order);

        return "redirect:/orders";
    }

    @GetMapping("/order/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);

        Collection<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "orders/add";
    }

    @PutMapping("/order")
    public String edit(Order order){
        orderService.save(order);

        return "redirect:/orders";
    }

    @DeleteMapping("/order/{id}")
    public String delete(@PathVariable Integer id){
        orderService.deleteOrderById(id);

        return "redirect:/orders";
    }
}
