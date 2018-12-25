package com.test.myapp.services;

import java.util.*;


public interface EmployeeService {

	
	List<Map<String,Object>> getAllEmployees(String employeeName);
	Map<String,Object> getEmployee(Long empId);
	Long saveEmployee(Map<String,Object> employee);
	void updateEmployee(Map<String,Object> employee);
	void deleteEmployee(Long empId);
	List<Map<String,Object>> getAllEmployeesFDe(String departmentName);
	Map<String,Object> getDepartment(Long deptId);
}
