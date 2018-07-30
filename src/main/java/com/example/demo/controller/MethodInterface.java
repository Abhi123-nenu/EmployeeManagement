package com.example.demo.controller;

import java.util.List;

import com.example.demo.exception.MyException;
import com.example.demo.pojo.Employee;

public interface MethodInterface {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee,String id);
	public Employee getEmployeeById(String id);
	public Employee getEmployeeByDesc(String desc);
	public Employee getEmployeeByName(String name);
	public List<Employee> getall()throws MyException;
	public String deleteById(String id);
	public String deleteAll();

}
