package com.example.demo.pojo;

import org.springframework.data.annotation.Id;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesc=" + empDesc + "]";
	}
	@Id
	private String empId;
	private String empName;
	private String empDesc;
	
	public Employee() {
		
	}
	public Employee(String empId, String empName, String empDesc) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesc = empDesc;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesc() {
		return empDesc;
	}
	public void setEmpDesc(String empDesc) {
		this.empDesc = empDesc;
	}
	

}
