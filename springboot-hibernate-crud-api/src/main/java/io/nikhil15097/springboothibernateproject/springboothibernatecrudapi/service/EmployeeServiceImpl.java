package io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.dao.EmployeeDAO;
import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	@Override
	public List<Employee> get() {
		return employeeDAO.get();
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
		
	}

}
