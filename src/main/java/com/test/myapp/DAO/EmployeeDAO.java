package com.test.myapp.DAO;

import java.util.List;

import com.test.myapp.models.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees(String employeeName);
	Employee getEmployee(Long empId);
	Object saveEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Long empId);
}
