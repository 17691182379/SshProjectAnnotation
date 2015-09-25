package cn.ssh.service.impl;

import java.util.Collection;

import cn.ssh.dao.EmployeeDao;
import cn.ssh.domain.Employee;
import cn.ssh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao<Employee> employeeDao;

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeDao.saveEntry(employee);		
	}

	@Override
	public void deleteEmployee(Integer id) {
		this.employeeDao.deleteEntry(id);		
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeDao.updateEntry(employee);		
	}

	@Override
	public Employee getEmployee(Integer id) {
		return this.employeeDao.getEntry(id);
	}

	@Override
	public Collection<Employee> getAllEmployee() {
		return this.employeeDao.getEmployee();
	}
	
	
	@Override
	public boolean getNameEmployee(String name) {
		return this.employeeDao.getNameEmployee(name) == null;
	}
	

	public EmployeeDao<Employee> getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao<Employee> employeeDao) {
		this.employeeDao = employeeDao;
	}

}
