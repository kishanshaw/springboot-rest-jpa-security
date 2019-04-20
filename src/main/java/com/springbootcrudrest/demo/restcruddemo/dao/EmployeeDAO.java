package com.springbootcrudrest.demo.restcruddemo.dao;

import java.util.List;

import com.springbootcrudrest.demo.restcruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee save(Employee employee);
	public void deleteEmployeeById(int id);
	

}
