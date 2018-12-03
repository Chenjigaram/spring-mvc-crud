package com.test.myapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.myapp.models.EmployeeBean;
import com.test.myapp.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@RequestMapping(value = "/employee/all/{employeeName}", method = RequestMethod.GET)
	public List<EmployeeBean> getAllEmployees(@PathVariable String employeeName) {
		return employeeService.getAllEmployees(employeeName);
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	public EmployeeBean getEmployee(@PathVariable Long empId) {
		return employeeService.getEmployee(empId);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Long saveEmployee(@RequestBody EmployeeBean employee) {
		System.out.println(employee.getAddress()+" "+employee.getEmpName());
		return employeeService.saveEmployee(employee);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public Boolean updateEmployee(@RequestBody EmployeeBean employee) {
		System.out.println(employee.getAddress()+" "+employee.getDateOfBirth());
		employeeService.updateEmployee(employee);
		return true;
		
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	public Boolean deleteEmployee(@PathVariable Long empId) {
		employeeService.deleteEmployee(empId);
		return true;
		
	}
}
