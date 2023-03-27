package com.dcf.Springboottutorial.service;

import com.dcf.Springboottutorial.entity.Department;
import com.dcf.Springboottutorial.error.DepartmentNotFoundException;
import com.dcf.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    // Save all departments
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    // Fetch all departments
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }
    // fetch department by Id
//    public Department getDepartmentById(Long departmentId) {
//        return departmentRepository.findById(departmentId).get();
//    }
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
         Optional<Department> department = departmentRepository.findById(departmentId);

         if(!department.isPresent()){
             throw new DepartmentNotFoundException("Department not available");

         }
        return department.get();
    }

    // Delete department by Id
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    // Update department by Id
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department deptDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(deptDB);
    }

    // Fetch department by Name
    public Department fetchDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentName(departmentName);
    }

    // Fetch department by code
        public Department fetchDepartmentByCode(String departmentCode){
            return departmentRepository.findByDepartmentCode(departmentCode);
        }
}
