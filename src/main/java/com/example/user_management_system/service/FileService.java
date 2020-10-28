package com.example.user_management_system.service;

import com.example.user_management_system.dao.FileDao;
import com.example.user_management_system.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    FileDao fileDao;

    public List<File> findAll(){
        return  fileDao.findAll();
    }

    public void deleteById(Long id){
        fileDao.deleteById(id);
    }
}
