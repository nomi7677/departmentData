package com.dcf.Springboottutorial.controller;


import com.dcf.Springboottutorial.entity.Department;
import com.dcf.Springboottutorial.error.DepartmentNotFoundException;
import com.dcf.Springboottutorial.service.DepartmentService;
import com.dcf.Springboottutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

   @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
       LOGGER.info("Inside saveDepartment of Department Controller class");
       return departmentService.saveDepartment(department);
   }

   @GetMapping("/departments")
    public List<Department> fetchDepartments(){
       return departmentService.fetchDepartments();
   }

   @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
       return departmentService.getDepartmentById(departmentId);
   }

   @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
       departmentService.deleteDepartment(departmentId);
       System.out.println("Department having department id is deleted successfully" + departmentId);
   }

   @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
       return departmentService.updateDepartmentById(departmentId, department);
   }

   @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
       return departmentService.fetchDepartmentByName(departmentName);
   }

    @GetMapping("/departments/code/{code}")
    public Department fetchDepartmentByCode(@PathVariable("code") String departmentCode){
        return departmentService.fetchDepartmentByCode(departmentCode);
    }
}
