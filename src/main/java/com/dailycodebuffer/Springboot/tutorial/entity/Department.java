package com.dailycodebuffer.Springboot.tutorial.entity;

import org.hibernate.validator.constraints.Length;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//TO CREATE TABLE WE USE @Entity
//TO CRREATE GETTERS ,SETTERS , CONSTRUCTOR, toString method for that WE USE @Data
//If we wanna only getters the @Getter n also same for @Setter
@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
// Builder it is pattern when you have multiple porpeties and u wnt to diff size of property to create the object
@Builder
public class Department {
//primary key
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long departmentId;
//hibernate validation we are doing for that we need to all hibernater validation dependency in pom.xml file
//for that we also need go to controller and add@valid annotation there
//when we add NotBlank annotation to field then it while creating data by using post method then add that time we not added name then it will give that message at bottaom
//THIS ALL DIFFERNET TYPE OF ANNOTATION USED FOR VALIDATE OUR JASON DATA
//@Length(max=5,min=1)
//@Size(max=10,min=0)
//@Email for email you can send regex exp
//for date filed we can use future date for @Future / @FutureOrPresent also for past days we use @Past/@PastorPresent
//@Positive @Negative annotion for date

//Lombok ALLOW US TO REMOVE BOILERPLATE CODE LIKE BELOW WRITE GETTERS SETTERS..MORE LINES...THTAS WHY WE USE NOW LOMBOK

@NotBlank(message="Please add Department Name")
private String departmentName;
private String departmentAddress;
private String departmentCode;


public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.departmentAddress = departmentAddress;
	this.departmentCode = departmentCode;
}

public Department() {
	super();
}

public Long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getDepartmentAddress() {
	return departmentAddress;
}
public void setDepartmentAddress(String departmentAddress) {
	this.departmentAddress = departmentAddress;
}
public String getDepartmentCode() {
	return departmentCode;
}
public void setDepartmentCode(String departmentCode) {
	this.departmentCode = departmentCode;
}

@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentAddress="
			+ departmentAddress + ", departmentCode=" + departmentCode + "]";
}


}



