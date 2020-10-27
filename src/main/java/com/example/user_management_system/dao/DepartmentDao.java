package com.example.user_management_system.dao;

import com.example.user_management_system.entity.Department;
import com.example.user_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Repository
//public class DepartmentDao {
//
//    private static Map<Integer, Department> departments;
//
//    static{
//        departments = new HashMap<>();
//
//        departments.put(1, new Department(1, "人事"));
//        departments.put(2, new Department(2, "开发"));
//        departments.put(3, new Department(3, "管理"));
//        departments.put(4, new Department(4, "战略投资"));
//    }
//
//    public Collection<Department> getAll(){ return departments.values(); }
//
//    public Department getDepartment(Integer id){ return departments.get(id); }
//}

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{
//    @Query(value="SELECT id FROM departments d WHERE d.leading_official = ?1, nativeQuery = true")
    List<Department> findByLeadingOfficial(Employee leadingOfficial);

    @Modifying
    @Transactional
    @Query(value="UPDATE departments d SET name = ?1, leading_official = null WHERE id = ?2 ;", nativeQuery=true)
    void customSave(String name, Integer id);
}