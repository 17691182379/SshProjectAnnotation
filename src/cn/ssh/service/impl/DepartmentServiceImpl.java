package cn.ssh.service.impl;

import java.util.Collection;

import cn.ssh.dao.DepartmentDao;
import cn.ssh.domain.Department;
import cn.ssh.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao<Department> departmentDao;

	@Override
	public void saveDepartment(Department department) {
		this.departmentDao.saveEntry(department);
	}

	@Override
	public void deleteDepartment(Integer id) {
		this.departmentDao.deleteEntry(id);
	}

	@Override
	public void updateDepartment(Department department) {
		this.departmentDao.updateEntry(department);
	}

	@Override
	public Department getDepartment(Integer id) {
		return this.departmentDao.getEntry(id);
	}

	@Override
	public Collection<Department> getAllDepartment() {
		return this.departmentDao.getAllEntry();
	}
	
	

	public DepartmentDao<Department> getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao<Department> departmentDao) {
		this.departmentDao = departmentDao;
	}

}
