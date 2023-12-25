package com.dailycodebuffer.Springboot.tutorial.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
// for to know that this is perticular test class is used
@SpringBootTest
public class DepartmentServiceTest {

	
	 @Autowired
	private DepartmentService departmentService;
	
	 @MockBean
	 
	 private DepartmentRepository departmentRepository;
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	 Department department=
			 Department.builder()
			   .departmentName("FE")
			   .departmentAddress("Banglore")
			   .departmentCode("IT-06")
			   .departmentId(1L)
			   .build();
	
	 Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("FE"))
	                                  .thenReturn(department);
	
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	@DisplayName("Get Data Based on Valid Department Name")

	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName="CE";
		Department found = departmentService.fetchDepartmentByName(departmentName);
	       // If both are equals then my test case is pass
		assertEquals(departmentName, found.getDepartmentName());
	}

}
