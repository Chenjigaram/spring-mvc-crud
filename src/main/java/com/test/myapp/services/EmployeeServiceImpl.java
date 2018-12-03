package com.test.myapp.services;
import java.util.ArrayList;
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
	@Override
	public List<EmployeeBean> getAllEmployees(String employeeName) {
		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		List<Employee> empEntitties = employeeDAO.getAllEmployees(employeeName);
		for(Employee emp:empEntitties) {
			EmployeeBean empBean = new EmployeeBean();
			empBean.setAddress(emp.getAddress());
			empBean.setDateOfBirth(emp.getDateOfBirth());
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
		EmployeeBean empBean = null;
		if(emp!=null) {
			empBean = new EmployeeBean();
		empBean.setAddress(emp.getAddress());
		empBean.setDateOfBirth(emp.getDateOfBirth());
		empBean.setEmpId(emp.getEmpId());
		empBean.setEmpName(emp.getEmpName());
		empBean.setMobileNumber(emp.getMobileNumber());
		}
		return empBean;
	}

	@Override
	public Long saveEmployee(EmployeeBean employee) {
		Employee empBean = new Employee();
		empBean.setAddress(employee.getAddress());
		empBean.setDateOfBirth(employee.getDateOfBirth());
		empBean.setEmpName(employee.getEmpName());
		empBean.setMobileNumber(employee.getMobileNumber());
		return (Long) employeeDAO.saveEmployee(empBean);
	}

	@Override
	public void updateEmployee(EmployeeBean employee){
		
		Employee empBean = new Employee();
		empBean.setAddress(employee.getAddress());
		empBean.setDateOfBirth(employee.getDateOfBirth());
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
