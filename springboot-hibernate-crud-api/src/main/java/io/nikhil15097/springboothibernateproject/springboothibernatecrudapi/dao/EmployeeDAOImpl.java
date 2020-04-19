package io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.nikhil15097.springboothibernateproject.springboothibernatecrudapi.model.Employee;

	

	@Repository
	public class EmployeeDAOImpl implements EmployeeDAO {
		
		
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		return employeeObj;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
	}

}
