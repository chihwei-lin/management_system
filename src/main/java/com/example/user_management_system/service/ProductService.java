package com.example.user_management_system.service;

import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public Collection<Product> findAll(){
        return productDao.findAll();
    }

    public Product findProductById(Integer id){
        return productDao.getOne(id);
    }

    public void save(Product product){
        productDao.save(product);
    }

    public void deleteProductById(Integer id){
        productDao.deleteById(id);
    }
}
