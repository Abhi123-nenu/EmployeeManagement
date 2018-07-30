package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.controller.EmployeeController;


@SpringBootApplication
public class EmployeeManagementApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	public static void main(String[] args) {
		logger.info("Start");
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	
	
}
