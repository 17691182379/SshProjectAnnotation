package cn.ssh.dao;

import java.util.Collection;

public interface EmployeeDao<T> extends BaseDao<T> {
	
	/**
	 * 查询所有员工，并查出员工所在部门
	 * @return 返回查询到的所有员工信息
	 */
	public Collection<T> getEmployee();
	
	/**
	 * 根据员工姓名查询
	 * @param name 接收员工姓名
	 * @return 返回查询到的员工
	 */
	public T getNameEmployee(String name);
	
}
