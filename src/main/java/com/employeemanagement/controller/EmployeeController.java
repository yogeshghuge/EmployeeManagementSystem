package com.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/insertEmployee")
	public String addEmployee(Model model) {
		
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "insertEmployee";
	}
	@PostMapping("/saveEmp")
	public String SaveEmployee(@ModelAttribute Employee employee) 
	{
		 empService.insertEmployee(employee);
		return "redirect:/viewAllEmployee";
	}

	@GetMapping("/viewAllEmployee")
	public String viewAllEmployee(Model model) 
	{
		model.addAttribute("listAllEmp",empService.getAllEmpoyee());
		return "allEmployeePage";	
	}

	@GetMapping("/updateEmp/{id}")
	public String updateEmployee(@PathVariable Integer id,Model model) 
	{
		Employee emp1= empService.getEmployeeById(id);
		model.addAttribute("upemp", emp1);
		return "updateEmpPage";	
	}

	@PostMapping("/updated/{id}")
	public String saveupdatedEmp(@PathVariable Integer id, @ModelAttribute Employee emp ) 
	{
		emp.setEmpId(id);
		 empService.insertEmployee(emp);
		return "redirect:/viewAllEmployee";
	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable Integer id) 
	{
		 empService.deleteEmpById(id);
		return "redirect:/viewAllEmployee";
		
	}

}
