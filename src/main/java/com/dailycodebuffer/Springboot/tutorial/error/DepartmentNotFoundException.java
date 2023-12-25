package com.dailycodebuffer.Springboot.tutorial.error;

public class DepartmentNotFoundException extends Exception{

	public DepartmentNotFoundException() {
		super();
	}
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	public  DepartmentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public  DepartmentNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
	//protected DepartmentNotFoundException(String message, Throwable cause)
	
}
