package com.springbootcrudrest.demo.restcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrudrest.demo.restcruddemo.dao.EmployeeDAO;
import com.springbootcrudrest.demo.restcruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	@Qualifier("employeeDAOJaoImpl")
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeDAO.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		Employee employee=employeeDAO.getEmployeeById(id);
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee1){
		employee1.setId(0);
		Employee emp=employeeDAO.save(employee1);
		return emp;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp){
		Employee employee=employeeDAO.save(emp);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		employeeDAO.deleteEmployeeById(id);
		
	}

}
