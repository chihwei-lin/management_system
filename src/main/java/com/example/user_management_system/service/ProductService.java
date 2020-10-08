package com.example.user_management_system.service;

import com.example.user_management_system.dao.ProductDao;
import com.example.user_management_system.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public Collection<Product> findAll(){
        return productDao.findAll();
    }

    public Page<Product> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return productDao.findAll(pageable);
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
