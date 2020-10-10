package com.example.user_management_system.dao;

import com.example.user_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public User findOneByUsername(String username);
}
