package io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.model.Employee;
import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeeService.get();
	}
	
	@PostMapping("/employee")
		public Employee save(@RequestBody Employee employeeObj) {
			employeeService.save(employeeObj);
			return employeeObj;
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee employeeobj= employeeService.get(id);
		if(employeeobj == null) {
			throw new RuntimeException("Employee with id"+id+"is not found");
		}
		return employeeobj;
	}
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable int id) {
		employeeService.delete(id);
	}
	
	
	@PutMapping("/employee")
	public void update(@RequestBody Employee employeeObj) {
	employeeService.save(employeeObj);
}
}

