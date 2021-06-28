package com.gg.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.datamodel.Employee;
import com.gg.exceptionhandling.ResourceNotFoundException;
import com.gg.service.EmployeeService;
import com.gg.service.EmployeeServiceException;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

    //Happy path, an employee is returned as response
	@GetMapping("/employee")
	public Employee getEmpl() throws ResourceNotFoundException, EmployeeServiceException {
		try {
			Employee emp = employeeService.getEmployee();

			if (emp == null) {
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception while getting exception");
		}
	}

    //no employee found so ResourceNotFoundException is thrown
	@GetMapping(value = "/employee2")
	public Employee getEmp2() throws ResourceNotFoundException, EmployeeServiceException {
		try {
			Employee emp = employeeService.getEmployeeNull();
			if (emp == null) {
				throw new ResourceNotFoundException("Employee not found");
			}

			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception while getting exception");
		}
	}

    //Some exception is thrown by service layer
	@GetMapping("/employee3")
	public Employee getEmp3() throws ResourceNotFoundException, EmployeeServiceException {
		try {
			Employee emp = employeeService.getEmployeeException();
			if (emp == null) {
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		} catch (EmployeeServiceException e) {
			throw new EmployeeServiceException("Internal Server Exception while getting exception");
		}
	}
}