package com.test.myapp.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.myapp.DAO.EmployeeDAO;
import com.test.myapp.models.Employee;
import com.test.myapp.models.EmployeeBean;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY"); 
	@Override
	public List<EmployeeBean> getAllEmployees(String employeeName) {
		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		List<Employee> empEntitties = employeeDAO.getAllEmployees(employeeName);
		for(Employee emp:empEntitties) {
			EmployeeBean empBean = new EmployeeBean();
			empBean.setAddress(emp.getAddress());
			if(emp.getDateOfBirth() != null) {
				empBean.setDateOfBirth(dateFormat.format(emp.getDateOfBirth().getTime()));
			}
			empBean.setEmpId(emp.getEmpId());
			empBean.setEmpName(emp.getEmpName());
			empBean.setMobileNumber(emp.getMobileNumber());
			employees.add(empBean);
		}
		return employees;
	}

	@Override
	public EmployeeBean getEmployee(Long empId) {
		Employee emp = employeeDAO.getEmployee(empId);
		EmployeeBean empBean = new EmployeeBean();
		empBean.setAddress(emp.getAddress());
		empBean.setDateOfBirth(dateFormat.format(emp.getDateOfBirth()));
		empBean.setEmpId(emp.getEmpId());
		empBean.setEmpName(emp.getEmpName());
		empBean.setMobileNumber(emp.getMobileNumber());
		return empBean;
	}

	@Override
	public Long saveEmployee(EmployeeBean employee) throws ParseException {
		Employee empBean = new Employee();
		empBean.setAddress(employee.getAddress());
		if(employee.getDateOfBirth() != null) {
			Calendar cal = Calendar. getInstance();
			cal.setTime(dateFormat.parse(employee.getDateOfBirth()));
			empBean.setDateOfBirth(cal);
		}
		empBean.setEmpName(employee.getEmpName());
		empBean.setMobileNumber(employee.getMobileNumber());
		return (Long) employeeDAO.saveEmployee(empBean);
	}

	@Override
	public void updateEmployee(EmployeeBean employee) throws ParseException {
		
		Employee empBean = new Employee();
		empBean.setAddress(employee.getAddress());
		if(employee.getDateOfBirth() != null) {
			Calendar cal = Calendar. getInstance();
			cal.setTime(dateFormat.parse(employee.getDateOfBirth()));
			empBean.setDateOfBirth(cal);
		}
		empBean.setEmpId(employee.getEmpId());
		empBean.setEmpName(employee.getEmpName());
		empBean.setMobileNumber(employee.getMobileNumber());
		employeeDAO.updateEmployee(empBean);
		
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeDAO.deleteEmployee(empId);
		
	}

}
