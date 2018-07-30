package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeManagementApplication;
import com.example.demo.pojo.Employee;

@RequestMapping("/employees")
@RestController
public class EmployeeController{
	
	Logger logger=EmployeeManagementApplication.logger;
	
	@Autowired
	private ServiceImpl serviceImpl; 
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	//@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		String str=serviceImpl.addEmployee(employee);
		return ResponseEntity.accepted().body(str);
			
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}")
	//@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,@PathVariable String id)
	{
		String str=serviceImpl.updateEmployee(employee,id);
		return ResponseEntity.accepted().body(str);
		
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/getbyid/{id}")
	public Employee getEmployeeById(@PathVariable String id)
	{
		return serviceImpl.getEmployeeById(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/getbyname/{name}")
	public Employee getEmployeeByName(@PathVariable String name)
	{
		return serviceImpl.getEmployeeByName(name);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/getbydesc/{desc}")
	public Employee getEmployeeByDesc(@PathVariable String desc)
	{
		
		return serviceImpl.getEmployeeByDesc(desc);
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	//@GetMapping("/all")
	public List<Employee> getEmployee()
	{
		return serviceImpl.getall();
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	//@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable String id)
	{
		    String str=serviceImpl.deleteById(id);
		    return ResponseEntity.accepted().body(str);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete")
	//@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAll()
	{
		    String str=serviceImpl.deleteAll();
		    return ResponseEntity.accepted().body(str);
	}

}
