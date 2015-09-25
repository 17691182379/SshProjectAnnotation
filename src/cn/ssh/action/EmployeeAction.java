package cn.ssh.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;

import cn.ssh.domain.Department;
import cn.ssh.domain.Employee;
import cn.ssh.service.DepartmentService;
import cn.ssh.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;

@Namespace("/")// 指定名称空间
@ParentPackage("struts-default")  // 指定继承的包，struts-default无需指定
@Action("emp")
@Results({
	@Result(name="listAction", location="/WEB-INF/views/emp-list.jsp"),
	@Result(name="ajax", type="stream"),
	@Result(name="updateUI", location="/WEB-INF/views/emp-update.jsp"),
	@Result(name="addUI", location="/WEB-INF/views/emp-add.jsp"),
	@Result(name="action2action", type="redirectAction", location="emp!list.action")
	
	
})  //指定success，因为success是默认的，所以不用指定name
public class EmployeeAction extends BaseAction<Employee> {

	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private InputStream inputStream;
	private String eid;
	private String did;
	private String ygName;
	
	
	public String list() {
		Collection<Employee> employees = this.employeeService.getAllEmployee();
		ActionContext.getContext().put("employees", employees);
		return listAction;
	}
	
	
	public String delete() {
		try {
			this.employeeService.deleteEmployee(Integer.parseInt(eid));
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax";
	}
	
	public String addUI() {
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		return addUI;
	}
	
	public String insert() {
		/**
		 * 如何获取页面中的数据
		 *    *  如果页面中的数据来源于一张表，直接用模型驱动获取就可以了
		 *    *  如果页面中的数据来源于多张表，则可以采用模型驱动结合属性驱动的方式
		 */
		/**
		 * 1、创建一个employee对象
		 * 2、把模型驱动的值赋值给employee对象
		 * 3、根据 部门id提取出该部门
		 * 4、建立employee对象和部门之间的关系
		 * 5、执行save操作
		 */
		Employee employee = new Employee();
		// 一般属性的赋值
		BeanUtils.copyProperties(this.getModel(), employee);
		// 建立员工与部门之间的关系
		Department department = this.departmentService.getDepartment(Integer.parseInt(did));
		employee.setDepartment(department);
		// 创建时间
		employee.setCreateTime(new Date());
		this.employeeService.saveEmployee(employee);		
		return action2action;
	}
	
	
	public String updateUI() {
		if (this.getModel().getId() != null) {
			Employee employee = this.getEmployeeService().getEmployee(this.getModel().getId());
			ActionContext.getContext().put("employee", employee);
			Collection<Department> departmentList = this.departmentService.getAllDepartment();
			ActionContext.getContext().put("departmentList", departmentList);
		}
		return updateUI;
	}
	
	public String update() {
		/**
		 * 1、利用模型驱动获取员工的一般数据
		 * 2、利用属性驱动获取最新的did和eid
		 * 3、根据员工的id提取出employee对象
		 * 4、把模型驱动的值复制到employee对象中
		 * 5、重新建立employee对象部门之间的关系
		 */
		// 一般属性的赋值
		Employee employee = this.employeeService.getEmployee(this.getModel().getId());
		Date createTime = employee.getCreateTime();
		BeanUtils.copyProperties(this.getModel(), employee);
		// 重新建立员工与部门之间的关系
		Department department = this.departmentService.getDepartment( this.getModel().getDepartment().getId());
		employee.setCreateTime(createTime);
		employee.setDepartment(department);
		this.employeeService.updateEmployee(employee);
		return action2action;
	}
	
	public String validateLastName() {
		if (this.employeeService.getNameEmployee(ygName)) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		}		
		return "ajax";
	}
	
	
	

	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getYgName() {
		return ygName;
	}
	public void setYgName(String ygName) {
		this.ygName = ygName;
	}
}
