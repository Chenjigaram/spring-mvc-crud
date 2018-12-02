package com.test.myapp.services;

import java.text.ParseException;
import java.util.List;
import com.test.myapp.models.EmployeeBean;

public interface EmployeeService {

	
	List<EmployeeBean> getAllEmployees(String employeeName);
	EmployeeBean getEmployee(Long empId);
	Long saveEmployee(EmployeeBean employee) throws ParseException;
	void updateEmployee(EmployeeBean employee) throws ParseException;
	void deleteEmployee(Long empId);
}
