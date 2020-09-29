package com.example.user_management_system.controller;

import com.example.user_management_system.dao.OrderDao;
import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Order;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @GetMapping("/orders")
    public String list(Model model){
        Collection<Order> orders = orderDao.getAll();
        model.addAttribute("orders", orders);

        return "orders/list";
    }

    @GetMapping("/order")
    public String toAddPage(Model model){
        Collection<Product> products = productDao.getAll();
        model.addAttribute("products", products);

        return "orders/add";
    }

    @PostMapping("/order")
    public String add(Order order){
        System.out.println(order.toString());
        orderDao.add(order);

        return "redirect:/orders";
    }

    @GetMapping("/order/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        Order order = orderDao.getOrderById(id);
        model.addAttribute("order", order);

        Collection<Product> products = productDao.getAll();
        model.addAttribute("products", products);

        return "orders/add";
    }

    @PutMapping("/order")
    public String edit(Order order){
        orderDao.add(order);

        return "redirect:/orders";
    }

    @DeleteMapping("/order/{id}")
    public String delete(@PathVariable Integer id){
        orderDao.delete(id);

        return "redirect:/orders";
    }
}
