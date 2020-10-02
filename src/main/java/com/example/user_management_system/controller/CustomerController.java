package com.example.user_management_system.controller;

import com.example.user_management_system.dao.CustomerDao;
import com.example.user_management_system.model.Customer;
import com.example.user_management_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String toListPage(Model model){

        Collection<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);

        return "customers/list";
    }

    @GetMapping("/customer")
    public String toAddPage(){
        return "customers/add";
    }

    @PostMapping("/customer")
    public String addCustomer(Customer customer){
        customerService.save(customer);

        return "redirect:/customers";
    }

    @GetMapping("/customer/{id}")
    public String toEditPage(@PathVariable Integer id, Model model){
        Customer customer = customerService.findCustomerById(id);
        model.addAttribute("customer", customer);

        return "customers/add";
    }

    @PutMapping("/customer")
    public String editCustomer(Customer customer){
        customerService.save(customer);

        return "redirect:/customers";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
