package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.Employee;

@Component
public interface Services extends MongoRepository<Employee, String>{
	
	public Employee findByEmpId(String empId);
	public Employee findByEmpName(String empName);
	public Employee findByEmpDesc(String empDesc);
	

}
