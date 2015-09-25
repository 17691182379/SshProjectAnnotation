package cn.ssh.service;

import java.util.Collection;

import cn.ssh.domain.Employee;

public interface EmployeeService {
	
	/**
	 * 添加一条员工信息
	 * @param emplyoee 接收员工实例对象
	 */
	public void saveEmployee(Employee employee);
	
	/**
	 * 删除一条员工信息
	 * @param id 接收要删除的员工id
	 */
	public void deleteEmployee(Integer id);
	
	/**
	 * 更新一条员工信息
	 * @param employee 接收员工实例对象
	 */
	public void updateEmployee(Employee employee);
	
	/**
	 * 获取一条员工信息
	 * @param id 指定要获取的员工id
	 * @return 返回获取的员工
	 */
	public Employee getEmployee(Integer id);
	
	/**
	 * 查询所有员工信息
	 * @return 返回查询到的所有员工
	 */
	public Collection<Employee> getAllEmployee();
	
	/**
	 * 根据员工姓名查询
	 * @param name 接收员工姓名
	 * @return 返回true 或 false
	 */
	public boolean getNameEmployee(String name);
	
}
