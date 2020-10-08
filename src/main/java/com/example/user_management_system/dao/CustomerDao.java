package com.example.user_management_system.dao;

import com.example.user_management_system.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.text.SimpleDateFormat;
import java.util.*;

//@Repository
//public class CustomerDao {
//
//    private static Map<Integer, Customer> customers;
//
//    static{
//        customers = new HashMap<>();
//        customers.put(1, new Customer(1, "李七", "93745656","liqi@example.com", "上海光明南路七号", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
//    }
//
//    private static Integer id = 2;
//
//    public Collection<Customer> getAll(){
//        return customers.values();
//    }
//
//    public Customer getCustomerById(Integer id){
//        return customers.get(id);
//    }
//
//    public void add(Customer customer){
//        if(customer.getId() == null){
//            customer.setId(id++);
//            customer.setCreated_date(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//        }
//
//        customers.put(customer.getId(), customer);
//    }
//
//    public void deleteCustomerById(Integer id){
//        customers.remove(id);
//    }
//}

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    Customer findCustomerByEmail(@Param("email") String email);
}