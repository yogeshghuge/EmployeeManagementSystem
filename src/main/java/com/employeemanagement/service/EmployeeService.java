package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRep;
	public Employee insertEmployee(Employee emp){
		
		return employeeRep.save(emp);
	}
	public List<Employee> getAllEmpoyee()
	{
		return employeeRep.findAll();
		
	}

	public Employee getEmployeeById(Integer id)  
	{
		 
		return employeeRep.findById(id).orElseThrow();
	}

	public void deleteEmpById(Integer id) 
	{
		employeeRep.deleteById(id);;
		
	} 
	
}
