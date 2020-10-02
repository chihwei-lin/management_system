package com.example.user_management_system.dao;

import com.example.user_management_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@Repository
//public class ProductDao {
//    private static Map<Integer, Product> products;
//
//    static{
//        products = new HashMap<>();
//        products.put(1, new Product(1, "苹果", 5));
//        products.put(2, new Product(2, "橙", 7));
//        products.put(3, new Product(3, "梨", 12));
//    }
//
//    private static Integer id = 4;
//
//    public Product getProductById(Integer id){
//        return products.get(id);
//    }
//
//    public Collection<Product> getAll(){
//        return products.values();
//    }
//
//    public void add(Product product){
//        if(!products.containsKey(product.getId()))
//            product.setId(id++);
//        products.put(product.getId(), product);
//    }
//}

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}