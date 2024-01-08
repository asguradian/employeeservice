package com.oci.backend.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.oci")
@SpringBootApplication
public class EmployeeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeserviceApplication.class, args);
	}

}
