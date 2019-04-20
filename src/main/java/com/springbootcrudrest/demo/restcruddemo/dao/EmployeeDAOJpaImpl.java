package com.springbootcrudrest.demo.restcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootcrudrest.demo.restcruddemo.entity.Employee;

@Repository
public class EmployeeDAOJaoImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employee = query.getResultList();
		return employee;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		Employee emp = entityManager.merge(employee);
		return emp;
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		entityManager.remove(employee);

	}

}
