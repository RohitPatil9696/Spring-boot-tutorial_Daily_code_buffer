package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

    //INSIDE IT WE ARE ADDING EXCEPTION HANDLING
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department=
				departmentRepository.findById(departmentId);
	    try {
			if(!department.isPresent()){
				throw new DepartmentNotFoundException("Department Not Available");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     return department.get();
	
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Department updateDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Department updateDepartment(Long departmentId, Department department) {

		Department depDB= departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(depDB);
	}


	@Override
	public Department fetchDepartmentByName(String departmentName) {
   
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}




}
