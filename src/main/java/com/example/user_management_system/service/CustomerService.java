package com.example.user_management_system.service;

import com.example.user_management_system.dao.CustomerDao;
import com.example.user_management_system.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    public Page<Customer> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size,Sort.by("id"));
        return customerDao.findAll(pageable);
    }


    public void save(Customer customer){
        customer.setCreated_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        customerDao.save(customer);
    }

    public Customer findCustomerById(Integer id){
        return customerDao.getOne(id);
    }

    public void deleteCustomerById(Integer id){
        customerDao.deleteById(id);
    }
}
