package com.secondproject.employeewebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondproject.employeewebapp.model.Employee;
import com.secondproject.employeewebapp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee e1) {
		return employeeRepo.save(e1);		
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee getEmployeesById(int eidd) {
		return employeeRepo.findById(eidd).get();
	}

	public void deleteEmployeeById(int eidd) {
		employeeRepo.deleteById(eidd);
		
	}
	


}
