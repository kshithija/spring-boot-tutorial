package com.dailypractice.springboot.tutorial.service;

import com.dailypractice.springboot.tutorial.entity.Department;
import com.dailypractice.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    Department save(Department department);

    Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    List<Department> findAllDepartments();

    public void deleteDepartmentByID(Long departmentId);

    Department updateDapartmentById(Long departmentId,Department department);

    Department fetchDepartmentByName(String departmentName);

    List<Department> fetchDepartmentByNameEndsWith(String departmentName);
}
