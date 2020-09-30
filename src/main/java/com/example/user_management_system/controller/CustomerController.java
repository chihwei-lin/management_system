package com.example.user_management_system.controller;

import com.example.user_management_system.dao.CustomerDao;
import com.example.user_management_system.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    @GetMapping("/customers")
    public String toListPage(Model model){

        Collection<Customer> customers = customerDao.getAll();
        model.addAttribute("customers", customers);

        return "customers/list";
    }

    @GetMapping("/customer")
    public String toAddPage(){
        return "customers/add";
    }

    @PostMapping("/customer")
    public String addCustomer(Customer customer){
        customerDao.add(customer);

        return "redirect:/customers";
    }

    @GetMapping("/customer/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        Customer customer = customerDao.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customers/add";
    }

    @PutMapping("/customer")
    public String editCustomer(Customer customer){
        System.out.println(customer.toString());
        customerDao.add(customer);

        return "redirect:/customers";
    }
}
