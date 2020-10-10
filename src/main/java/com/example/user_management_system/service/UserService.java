package com.example.user_management_system.service;

import com.example.user_management_system.dao.UserDao;
import com.example.user_management_system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public Page<User> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return userDao.findAll(pageable);
    }

    public User findUserById(Integer id){
        return userDao.getOne(id);
    }

    public User findUserByUsername(String username){
        return userDao.findOneByUsername(username);
    }

    public void save(User user){
        userDao.save(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }
}
