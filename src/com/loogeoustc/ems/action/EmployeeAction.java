package com.loogeoustc.ems.action;

import java.util.List;

import com.loogeoustc.ems.domain.Department;
import com.loogeoustc.ems.domain.Employee;
import com.loogeoustc.ems.domain.PageBean;
import com.loogeoustc.ems.service.DepartmentService;
import com.loogeoustc.ems.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	private static final long serialVersionUID = -3439769846148102460L;
	//ģ��������Ҫʹ�õĶ��󣬽�ǰ̨ҳ�������װ���ö����У�
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}

	
	//ע��ҵ������
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/*
	 * ��½ִ�з���
	 */
	public String login() {
		//System.out.println("login!");
		Employee existEmployee = employeeService.login(employee);
		if(null == existEmployee){
			this.addActionError("�û������������");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		
		//��pageBean���뵽ֵջ�У�
		ActionContext.getContext().getValueStack().push(pageBean);;
		return "findAll";
	}
	
	public String save(){
		this.employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String saveUI(){
		List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("departments",departments);
		return "saveUI";
	}
	
	public String edit(){
		//System.out.println(employee.getEid());
		employee = employeeService.findById(employee.getEid());List<Department> departments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("departments",departments);
		
		return "editSuccess";
	}
	
	public String update(){
		this.employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employee = this.employeeService.findById(employee.getEid());
		this.employeeService.delete(employee);
		return "deleteSuccess";
	}
}
