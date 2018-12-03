package com.test.myapp.services;

import java.util.List;
import com.test.myapp.models.EmployeeBean;

public interface EmployeeService {

	
	List<EmployeeBean> getAllEmployees(String employeeName);
	EmployeeBean getEmployee(Long empId);
	Long saveEmployee(EmployeeBean employee);
	void updateEmployee(EmployeeBean employee);
	void deleteEmployee(Long empId);
}
