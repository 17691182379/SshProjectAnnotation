package cn.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ssh.domain.Employee;
import cn.ssh.service.EmployeeService;

public class AddTest {
	
	private ApplicationContext context;
	
	{
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	
	@Test
	public void testAdd() throws Exception {
		
		EmployeeService employeeSevice = (EmployeeService) context.getBean("employeeService");
		
//		Department department = new Department(7, "运输部");
		Employee employee = new Employee(6, "王超", "wc@163.com", null, new Date());
		employee.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-13"));
//		employee.setDepartment(department);
		System.out.println(employee);
		employeeSevice.saveEmployee(employee);
		
		
	}
	
}
