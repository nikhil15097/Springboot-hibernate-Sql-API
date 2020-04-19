package io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.service;

import java.util.List;

import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.model.Employee;

public interface EmployeeService {
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
