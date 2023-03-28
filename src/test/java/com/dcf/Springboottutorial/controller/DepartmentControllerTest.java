package com.dcf.Springboottutorial.controller;

import com.dcf.Springboottutorial.entity.Department;
import com.dcf.Springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department=Department.builder().departmentAddress("Bear").departmentCode("IT106").departmentName("IT").departmentId(1L).build();

    }

//    @Test
//    void saveDepartment() {
//
//    }
//
//    @Test
//    void getDepartmentById() {
//    }
}