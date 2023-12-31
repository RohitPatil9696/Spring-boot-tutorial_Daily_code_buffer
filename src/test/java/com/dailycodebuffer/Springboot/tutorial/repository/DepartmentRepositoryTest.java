package com.dailycodebuffer.Springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager; 
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		Department department=
				Department.builder()
				        .departmentName("Fluid Engineering")
		                 .departmentCode("FE, 010")
		                 .departmentAddress("Kolhapur")
		                 .build();
		entityManager.persist(department);
	}

	public void whenFindById_thenReturnDepartment() {
		
		Department department= departmentRepository.findById(1L).get();
	  assertEquals(department.getDepartmentName(), "Fluid Engineering");
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
