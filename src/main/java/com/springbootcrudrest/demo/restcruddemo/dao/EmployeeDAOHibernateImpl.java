package com.springbootcrudrest.demo.restcruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootcrudrest.demo.restcruddemo.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entity manager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		//get current hibernate session using entity manager
		Session session=entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query= session.createQuery("from Employee",Employee.class);
		
		List<Employee> employees=query.getResultList();
		
		return employees;
	}


	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee;
	}


	@Override
	@Transactional
	public Employee save(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;
		
	}


	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee emp=session.get(Employee.class, id);
		
		session.delete(emp);
		
	}


	

}
