/*package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import com.example.demo.controller.EmployeeController;
import com.example.demo.exception.MyException;

//@RunWith(SpringRunner.class)
public class GetEmployeesTest {
	
	private MockMvc mockmvc;
	
	@MockBean
	private EmployeeController ec;
	
	@Before
	public void setUp() throws Exception{
		mockmvc=MockMvcBuilders.standaloneSetup(ec).build();
	}
	
	@Test
	public void getall() throws Exception{	
		mockmvc.perform(MockMvcRequestBuilders.get("/employees/all"))
				.andExpect(status().isOk());			
	}
	
	@Test(expected=NestedServletException.class)
	public void getEmployeeById() throws Exception{	
		mockmvc.perform(MockMvcRequestBuilders.get("/employees/getbyid/5b4c3d9f005c7a21e45e5f58"))
				.andExpect(status().isOk());
	}
	
	
	

}
*/