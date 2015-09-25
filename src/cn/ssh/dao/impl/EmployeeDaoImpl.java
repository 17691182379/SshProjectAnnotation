package cn.ssh.dao.impl;

import java.util.Collection;

import org.hibernate.Query;

import cn.ssh.dao.EmployeeDao;
import cn.ssh.domain.Employee;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao<Employee> {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Employee> getEmployee() {
		String hql = "from Employee e left outer join fetch e.department order by e.id";
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public Employee getNameEmployee(String name) {
		String hql = "from Employee e where last_name = ?";
		Query query = this.getSession().createQuery(hql).setString(0, name);
		Employee employee = (Employee) query.uniqueResult();
		if (employee != null) {
			return employee;
		} else {
			return null;
		}
			
	}
	
}
