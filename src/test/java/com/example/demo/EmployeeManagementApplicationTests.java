package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.demo.controller.EmployeeController;
import com.example.demo.controller.ServiceImpl;
import com.example.demo.pojo.Employee;
import com.example.demo.repository.Services;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeManagementApplicationTests {
	
	@Autowired
	ServiceImpl si;
	
	
	EmployeeController ec;
	Services services;
	ArrayList<Employee> li=new ArrayList();

	@Before
	public void create()
	{
		si=new ServiceImpl();
		services=mock(Services.class);
		ReflectionTestUtils.setField(si, "services", services);
		li.add(new Employee("11","Abhinay","developer"));
		when(services.findAll()).thenReturn(li);
		when(services.findByEmpId("11")).thenReturn(new Employee("11","Abhinay","developer"));
		li.add(new Employee("12","AbhinaySai","tester"));
		when(services.findByEmpDesc("developer")).thenReturn(new Employee("11","Abhinay","developer"));
		when(services.findByEmpName("Abhinay")).thenReturn(new Employee("11","Abhinay","developer"));
		//when(services.deleteById("12")).thenReturn("Deleted");
	}
	
	@Test
	public void getEmpbyIdTest() {
		ArrayList<Employee> li1=new ArrayList();
		Employee result=si.getEmployeeById("11");
		li1.add(result);
		assertEquals(li.get(0).getEmpId(), li1.get(0).getEmpId());
	}
		
		@Test
		public void getEmpbyDescTest()
		{
			ArrayList<Employee> li1=new ArrayList();
			Employee result=si.getEmployeeByDesc("developer");
			li1.add(result);
			assertEquals(li.get(0).getEmpDesc(), li1.get(0).getEmpDesc());
		}
		
		@Test
		public void getEmpbyNameTest()
		{
			ArrayList<Employee> li1=new ArrayList();
			Employee result=si.getEmployeeByName("Abhinay");
			li1.add(result);
			assertEquals(li.get(0).getEmpName(), li1.get(0).getEmpName());
		}
		@Test
		public void getEmpTest()
		{
			
			List<Employee> result=si.getall();
			if(result.isEmpty())
				assertNull(result);
			else
				assertNotNull(result);
		
		}
		//@Test
		/*public void deleteTest()
		{
			si.deleteById("12");
			assertTrue(si.deleteById("12"));

		}*/
}
