package com.secondproject.employeewebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secondproject.employeewebapp.model.Employee;
import com.secondproject.employeewebapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/listAllEmployee")
	public String getAllEmployee(Model bm)
	{
		List<Employee> allemployee= employeeService.getAllEmployee();
		bm.addAttribute("employees",allemployee);
		return "list-employee";
	}
	
	
	@GetMapping("/createEmployee")
	public String createEmployee(Model theModel)
	{
		Employee e1=new Employee();
		theModel.addAttribute("employee",e1);
		return "employee-form";	
	}
	
	@PostMapping("/save")
	public String addEmployeeByObjectBody(
	@ModelAttribute("employee") Employee e1)
	{
	employeeService.addEmployee(e1);
	return "redirect:/employees/listAllEmployee";
	}
	
	@PostMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId")int eidd, Model theModel ) {
		Employee dbemployee=employeeService.getEmployeesById(eidd);
		theModel.addAttribute("employee",dbemployee);
		return "employee-form";
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId")int eidd) {
		employeeService.deleteEmployeeById(eidd);
		return "redirect:/employees/listAllEmployee";
	}

}
