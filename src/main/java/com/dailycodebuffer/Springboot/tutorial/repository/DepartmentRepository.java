package com.dailycodebuffer.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findByDepartmentName(String departmentName);
    // JPA Query Documentation :https://docs.spring.io/spring-data/jp... inbuilt method

	//if method Name is not available in JPARepository then we add @query annotaion and write our Query in that
	//if query is complex then we can use native that is SQL or gpql query in gpql/native we need to add ?1 for one parameter ?2 for second parameter like wisw we have to add
	//@Query(value="",nativeQuery=true)
	public Department findByDepartmentNameIgnoreCase(String departmentName);


}
