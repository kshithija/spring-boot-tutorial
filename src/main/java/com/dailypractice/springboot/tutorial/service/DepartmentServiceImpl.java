package com.dailypractice.springboot.tutorial.service;

import com.dailypractice.springboot.tutorial.controller.DepartmentController;
import com.dailypractice.springboot.tutorial.entity.Department;
import com.dailypractice.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailypractice.springboot.tutorial.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

@Autowired
private DepartmentRepository departmentRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Override
    public Department save(Department department) {
        LOGGER.info("Department service save");
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Avaialbe");
        }
        return department.get();
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentByID(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDapartmentById(Long departmentId, Department department) {
        Department departmentdb = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentdb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentdb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentdb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentdb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public List<Department> fetchDepartmentByNameEndsWith(String departmentName) {
        return departmentRepository.findByDepartmentNameEndsWith(departmentName);
    }


}
