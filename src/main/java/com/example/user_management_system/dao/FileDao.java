package com.example.user_management_system.dao;

import com.example.user_management_system.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDao extends JpaRepository<File, Long> {

}
