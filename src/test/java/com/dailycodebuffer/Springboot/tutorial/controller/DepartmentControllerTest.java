package com.dailycodebuffer.Springboot.tutorial.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
	
	 Department department= Department.builder()
			           .departmentAddress("Banglore")
			           .departmentCode("IT-06")
			           .departmentName("IT")
			           .departmentId(1L)
			           .build();
	
	
	}

	@Test
	void testSaveDepartment() throws Exception {
   
	Department	 inputDepartment= Department.builder()
		           .departmentAddress("Banglore")
		           .departmentCode("IT-06")
		           .departmentName("IT")
		           .build();

	
	Mockito.when(departmentService.saveDepartment(inputDepartment))
	     .thenReturn(department);
	
	mockMvc.perform(MockMvcRequestBuilders.post("/departments")
			         .contentType(MediaType.APPLICATION_JSON)
			         .content("{\r\n" + 
			         		"      \"departmentName\":\"IT\",\r\n" + 
			         		"    \"departmentAddress\":\"Banglore\",\r\n" + 
			         		"    \"departmentCode\":\"IT-06\"\r\n" + 
			         		"    \r\n" + 
			         		"}"
			         		+ ""))
	                        .andExpect(MockMvcResultMatchers.status().isOk());
			
			
	}

	@Test
	void testFetchDepartmentById() {

		//Mockito.when(departmentService.fetchDepartmentById(department))
		//.thenReturn(department);
		
		
//	mockMvc.perform(get("/departments/1")
//			.contentType(MediaType.APPLICATION_JSON))
//	          .andExpect(status().isOk())
//	          .andExpect((ResultMatcher) jsonPath("$.departmentName")
//	        		 .value(department.getDepartmentName()));
	}

}
