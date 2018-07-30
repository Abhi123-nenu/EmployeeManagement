package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.EmployeeManagementApplication;
import com.example.demo.exception.MyException;
import com.example.demo.pojo.Employee;
import com.example.demo.repository.Services;

@Component
public class ServiceImpl implements MethodInterface{
	
	Logger logger=EmployeeManagementApplication.logger;

	
	@Autowired
	private Services services;
	
		
	@Override
	public String addEmployee(Employee employee)throws MyException
	{
		if(employee.getEmpName().isEmpty())
		{
			throw new MyException("Name is empty");
		}
		else if(employee.getEmpDesc().isEmpty())
			throw new MyException("Designation is empty");
		else 
		{
			services.save(employee);
			return employee.getEmpId()+" \n"+employee.getEmpDesc()+" \n"+employee.getEmpName()+"\nEmployee Added Successfully";
		}
		
	}
	
	@Override
	public String updateEmployee(Employee employee,String id)throws MyException
	{
		if(employee.getEmpName().isEmpty())
		{
			throw new MyException("Name is empty");
		}
		else if(employee.getEmpDesc().isEmpty())
			throw new MyException("Designation is empty");
		else 
		{
			services.save(employee);
			return employee.getEmpId()+" \n"+employee.getEmpDesc()+" \n"+employee.getEmpName()+"\nEmployee Added Successfully";
		}
	}
	
	@Override
	public List<Employee> getall()throws MyException
	{
		List<Employee> employeeList=services.findAll();
		if(employeeList.isEmpty())
			throw new MyException("No Records To Fetch..");
		else
				return services.findAll();
	}
	
	@Override
	public String deleteById(String id)throws MyException
	{
		List<Employee> employeeList=services.findAll();

		List<Employee> e=employeeList.stream().filter(t -> t.getEmpId().equals(id)).collect(Collectors.toList());
		if(e.isEmpty())
			throw new MyException("No Employee exists with that ID...");
		else
		{
		    services.deleteById(id);
		    return "Employee with id: "+id+" is deleted Successfully";
		}
		
	}

	@Override
	public Employee getEmployeeById(String id)throws MyException
	{
		List<Employee> employeeList=services.findAll();
		//List<Employee> e=employeeList.stream().filter(t -> t.getEmpId().equals(id)).collect(Collectors.toList());
		if(employeeList.isEmpty())
			throw new MyException("No Employee exists with that ID...");
		else
		{
			System.out.println(employeeList);
			System.out.println("calling..................");
		    return services.findByEmpId(id);
		}
	}
	
	@Override
	public Employee getEmployeeByName(String name)throws MyException
	{
		List<Employee> employeeList=services.findAll();
		List<Employee> e=employeeList.stream().filter(t -> t.getEmpName().equals(name)).collect(Collectors.toList());
		if(e.isEmpty())
			throw new MyException("No Employee exists with that Name...");
		else
		{
		    return services.findByEmpName(name);
		}
	}
	
	@Override
	public Employee getEmployeeByDesc(String desc)throws MyException
	{
		List<Employee> employeeList=services.findAll();
		List<Employee> e=employeeList.stream().filter(t -> t.getEmpDesc().equals(desc)).collect(Collectors.toList());
		if(e.isEmpty())
			throw new MyException("No Employee exists with that Designation...");
		else
		{
		    return services.findByEmpDesc(desc);
		}
	}
	
	@Override
	public String deleteAll()
	{
		List<Employee> employeeList=services.findAll();
		if
		(employeeList.isEmpty())
			throw new MyException("No Records Available to delete...");
		else
		{
			services.deleteAll();
			return "Deleted";
		}
	}
	

	

}
