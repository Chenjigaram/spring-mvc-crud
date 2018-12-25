package com.test.myapp.services;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.myapp.DAO.EmployeeDAO;
import com.test.myapp.models.Address;
import com.test.myapp.models.Department;
import com.test.myapp.models.Employee;
import com.test.myapp.models.EmployeeBean;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	public List<Map<String,Object>> getAllEmployees(String employeeName) {
		List<Map<String,Object>> employees = new ArrayList<Map<String,Object>>();
		List<Employee> empEntitties = employeeDAO.getAllEmployees(employeeName);
		for(Employee emp:empEntitties) {	
			employees.add(mapTheEmployee(emp,true));
		}
		return employees;
	}

	@Override
	public Map<String,Object> getEmployee(Long empId) {
		Employee emp = employeeDAO.getEmployee(empId);
		if(emp!=null) {
			return mapTheEmployee(emp,true);
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Long saveEmployee(Map<String,Object> employee) {
		Employee empBean = new Employee();
		empBean.setAddress(mapTheAddressToAdd((Map<String, Object>) employee.get("address")));
		empBean.setDateOfBirth((String) employee.get("dateOfBirth"));
		empBean.setEmpName((String) employee.get("employeeName"));
		empBean.setMobileNumber(new Long((Integer) employee.get("mobileNumber")));
		empBean.setDepartment(mapTheDepartmentToDep((List<Map<String, Object>>) employee.get("department")));
		return (Long) employeeDAO.saveEmployee(empBean);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void updateEmployee(Map<String,Object> employee){
		
		Employee empBean = new Employee();
		empBean.setAddress(mapTheAddressToAdd((Map<String, Object>) employee.get("address")));
		empBean.setDateOfBirth((String) employee.get("dateOfBirth"));
		empBean.setEmpId(new Long((Integer) employee.get("employeeId")));
		empBean.setEmpName((String) employee.get("employeeName"));
		empBean.setMobileNumber(new Long((Integer) employee.get("mobileNumber")));
		empBean.setDepartment(mapTheDepartmentToDep((List<Map<String, Object>>) employee.get("department")));
		employeeDAO.updateEmployee(empBean);
		
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeDAO.deleteEmployee(empId);
		
	}
	
	public Map<String,Object> mapTheEmployee(Employee employee,Boolean dept){
		Map<String,Object> mappedValue = new HashMap<String,Object>();
		mappedValue.put("employeeId", employee.getEmpId());
		mappedValue.put("employeeName", employee.getEmpName());
		mappedValue.put("address", mapTheAddress(employee.getAddress()));
		if(dept) {
			mappedValue.put("department", mapTheDepartment(employee.getDepartment()));
		}
		mappedValue.put("dateOfBirth", employee.getDateOfBirth());
		mappedValue.put("mobileNumber", employee.getMobileNumber());
		return mappedValue;
		
	}
	public Map<String,Object> mapTheAddress(Address address){
		Map<String,Object> mappedValue = new HashMap<String,Object>();
		mappedValue.put("street", address.getStreet());
		mappedValue.put("city", address.getCity());
		mappedValue.put("state", address.getState());
		mappedValue.put("zipcode", address.getZipcode());
		return mappedValue;
	}
	public List<Map<String,Object>> mapTheDepartment(List<Department> department){
		List<Map<String,Object>> departments = new ArrayList<Map<String,Object>>();
		for(Department dept:department) {
			Map<String,Object> mappedValue = new HashMap<String,Object>();
			mappedValue.put("departmentName", dept.getDepartmentName());
			mappedValue.put("companyName", dept.getCompanyName());
		departments.add(mappedValue);
		}
	
		return departments;
	}
//	public Map<String,Object> mapTheDepartment(Department department){
//	
//			Map<String,Object> mappedValue = new HashMap<String,Object>();
//			mappedValue.put("departmentName", department.getDepartmentName());
//			mappedValue.put("companyName", department.getCompanyName());
//			
//		return mappedValue;
//	}
	public Address mapTheAddressToAdd(Map<String,Object> address){
		Address mappedValue = new Address();
		mappedValue.setCity((String) address.get("city"));
		mappedValue.setStreet((String) address.get("street"));
		mappedValue.setState((String) address.get("state"));
		mappedValue.setZipcode((String) address.get("zipcode"));
		return mappedValue;
	}
	public List<Department> mapTheDepartmentToDep(List<Map<String,Object>> department){
		List<Department> depts = new ArrayList<Department>();
		for(Map<String,Object> dept :department) {
			Department mappedValue = new Department();
			mappedValue.setDepartmentName((String) dept.get("departmentName"));
			mappedValue.setCompanyName((String) dept.get("companyName"));
			depts.add(mappedValue);
		}
		return depts;
	}
//	public Department mapTheDepartmentToDep(Map<String,Object> department){
//	
//			Department mappedValue = new Department();
//			mappedValue.setDepartmentName((String) department.get("departmentName"));
//			mappedValue.setCompanyName((String) department.get("companyName"));
//			
//		return mappedValue;
//	}
	public Map<String,Object> getMapTheDepartment(Department department){
		Map<String,Object> mappedValue = new HashMap<String,Object>();
		mappedValue.put("departmentName", department.getDepartmentName());
		mappedValue.put("companyName", department.getCompanyName());
		mappedValue.put("employee", mapTheEmployee(department.getEmployee(),false));
		return mappedValue;
	}
//	public Map<String,Object> getMapTheDepartment(Department department){
//		Map<String,Object> mappedValue = new HashMap<String,Object>();
//		mappedValue.put("departmentName", department.getDepartmentName());
//		mappedValue.put("companyName", department.getCompanyName());
//		List<Map<String,Object>> employees = new ArrayList<Map<String,Object>>();
//		for(Employee emp : department.getEmployee()) {
//			employees.add(mapTheEmployee(emp,false));
//		}
//		mappedValue.put("employees", employees);
//		return mappedValue;
//	}

	@Override
	public List<Map<String, Object>> getAllEmployeesFDe(String departmentName) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> departments = new ArrayList<Map<String,Object>>();
		List<Department> deptEntitties = employeeDAO.getAllEmployeesFDe(departmentName);
		for(Department emp:deptEntitties) {	
			departments.add(getMapTheDepartment(emp));
		}
		return departments;
	}

	@Override
	public Map<String, Object> getDepartment(Long deptId) {
		// TODO Auto-generated method stub
		return getMapTheDepartment(employeeDAO.getDepartment(deptId));
	}
	
	
}
