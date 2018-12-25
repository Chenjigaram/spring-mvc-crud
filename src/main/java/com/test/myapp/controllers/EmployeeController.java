package com.test.myapp.controllers;

import java.util.List;
import java.util.Map;
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
	public List<Map<String,Object>> getAllEmployees(@PathVariable String employeeName) {
		return employeeService.getAllEmployees(employeeName);
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	public Map<String,Object> getEmployee(@PathVariable Long empId) {
		return employeeService.getEmployee(empId);
	}
	@RequestMapping(value = "/department/all/{departmentName}", method = RequestMethod.GET)
	public List<Map<String,Object>> getAlDepartments(@PathVariable String departmentName) {
		return employeeService.getAllEmployeesFDe(departmentName);
	}

	@RequestMapping(value = "/department/{deptId}", method = RequestMethod.GET)
	public Map<String,Object> getDepartment(@PathVariable Long deptId) {
		return employeeService.getDepartment(deptId);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Long saveEmployee(@RequestBody Map<String,Object> employee) {
		return employeeService.saveEmployee(employee);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public Boolean updateEmployee(@RequestBody Map<String,Object> employee) {
		employeeService.updateEmployee(employee);
		return true;
		
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	public Boolean deleteEmployee(@PathVariable Long empId) {
		employeeService.deleteEmployee(empId);
		return true;
		
	}
}
