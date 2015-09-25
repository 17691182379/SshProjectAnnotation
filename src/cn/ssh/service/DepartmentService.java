package cn.ssh.service;

import java.util.Collection;

import cn.ssh.domain.Department;

public interface DepartmentService {
	
	/**
	 * 添加一条部门信息
	 * @param department 接收部门实例对象
	 */
	public void saveDepartment(Department department);
	
	/**
	 * 删除一条部门信息
	 * @param id 接收要删除的部门id
	 */
	public void deleteDepartment(Integer id);
	
	/**
	 * 更新一条部门信息
	 * @param department 接收部门实例对象
	 */
	public void updateDepartment(Department department);
	
	/**
	 * 获取一条部门信息
	 * @param id 指定要获取的部门id
	 * @return 返回获取的部门
	 */
	public Department getDepartment(Integer id);
	
	/**
	 * 查询所有部门信息
	 * @return 返回查询到的所有部门
	 */
	public Collection<Department> getAllDepartment();
	
}
