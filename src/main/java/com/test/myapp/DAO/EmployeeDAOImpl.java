package com.test.myapp.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.myapp.models.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSess() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees(String employeeName) {
		// TODO Auto-generated method stub
		return getSess().createQuery("from Employee e where e.empName = '"+employeeName+"'").list();
	}

	@Override
	public Employee getEmployee(Long empId) {
		// TODO Auto-generated method stub
		return getSess().get(Employee.class, empId);
	}

	@Override
	public Object saveEmployee(Employee employee) {
		return getSess().save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSess().update(employee);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteEmployee(Long empId) {
		getSess().createSQLQuery("delete from Employee e where e.empId = "+empId).executeUpdate();
		
	}

}
