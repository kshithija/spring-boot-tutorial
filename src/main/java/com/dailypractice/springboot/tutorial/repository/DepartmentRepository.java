package com.dailypractice.springboot.tutorial.repository;

import com.dailypractice.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    @Query("select u from Department u where u.departmentName like %?1")
    List<Department> findByDepartmentNameEndsWith(String departmentName);
}
