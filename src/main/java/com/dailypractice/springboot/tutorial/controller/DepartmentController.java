package com.dailypractice.springboot.tutorial.controller;

import com.dailypractice.springboot.tutorial.entity.Department;
import com.dailypractice.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailypractice.springboot.tutorial.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

   private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Department Controller save");
        return departmentService.save(department);
    }

    @GetMapping("/departments/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException
    {
        LOGGER.info("Department Controller find by id");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/departments/all")
    public List<Department> findAllDepartmentId(){
        LOGGER.info("Department Controller find all ids");
        return departmentService.findAllDepartments();
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Department Controller delete by Id");
        departmentService.deleteDepartmentByID(departmentId);
        return "Department Deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateByID(@PathVariable("id") Long departmentId, @Valid @RequestBody Department department){
        LOGGER.info("Department Controller Update by ID");
        return departmentService.updateDapartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
    @GetMapping("/departments/nameendswith/{name}")
    public List<Department> fetchDepartmentByNameEndsWith(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByNameEndsWith(departmentName);
    }




}
