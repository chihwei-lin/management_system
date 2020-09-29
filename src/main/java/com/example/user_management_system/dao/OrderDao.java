package com.example.user_management_system.dao;

import com.example.user_management_system.model.Order;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDao {
    @Autowired
    ProductDao productDao;

    private static Map<Integer, Order> orders;

    static{
        orders = new HashMap<>();
        orders.put(1, new Order(1, new Product(1, "苹果", 5), 10, 50, "李七", "liqi@example.com", "上海光明南路七号"));
    }

    private static Integer id = 2;

    public Collection<Order> getAll(){
        return orders.values();
    }

    public Order getOrderById(Integer id){
        return orders.get(id);
    }

    public void add(Order order){
        if(order.getId()==null)
            order.setId(id++);
        order.setProduct(productDao.getProductById(order.getProduct().getId()));
        order.setTotalPrice(order.getProduct().getPrice() * order.getQuantity());
        orders.put(order.getId(), order);
    }

    public void delete(Integer id){
        if(id == this.id-1)
            this.id--;
        orders.remove(id);
    }
}
