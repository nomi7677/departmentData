package com.dcf.Springboottutorial.repository;

import com.dcf.Springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Disabled
    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentName("Mechanical Engg").departmentCode("MEG123").departmentAddress("Bear").departmentId(2L).build();
        entityManager.persist(department);
    }

 //test case


   @Test


   @Disabled
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(2L).get();

        assertEquals(department.getDepartmentName(),"Mechanical Engg");
    }

}