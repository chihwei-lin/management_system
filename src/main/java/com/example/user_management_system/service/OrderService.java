package com.example.user_management_system.service;

import com.example.user_management_system.dao.CustomerDao;
import com.example.user_management_system.dao.OrderDao;
import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Order;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    CustomerDao customerDao;

    public Collection<Order> findAll(){
        return orderDao.findAll();
    }

    public Page<Order> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return orderDao.findAll(pageable);
    }

    public void save(Order order){
        order.setProduct(productDao.getOne(order.getProduct().getId()));
        order.setTotalPrice(order.getProduct().getPrice() * order.getQuantity());
        order.setCustomer(customerDao.findCustomerByEmail(order.getCustomer().getEmail()));

        orderDao.save(order);
    }

    public Order getOrderById(Integer id){
        return orderDao.getOne(id);
    }

    public void deleteOrderById(Integer id){
        orderDao.deleteById(id);
    }
}
