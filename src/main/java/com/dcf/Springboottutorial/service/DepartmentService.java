package com.dcf.Springboottutorial.service;

import com.dcf.Springboottutorial.entity.Department;
import com.dcf.Springboottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
    public Department fetchDepartmentByCode(String departmentCode);
}
