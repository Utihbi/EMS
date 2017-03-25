package com.loogeoustc.ems.action;

import java.util.List;

import com.loogeoustc.ems.domain.Department;
import com.loogeoustc.ems.domain.PageBean;
import com.loogeoustc.ems.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private static final long serialVersionUID = 4032008961951903039L;

	Department department = new Department();
	//������ǰ̨��������
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		
		//��pageBean���뵽ֵջ�У�
		ActionContext.getContext().getValueStack().push(pageBean);;
		return "findAll";
	}
	

	public String save(){
		//System.out.println(department.getDname());
		//System.out.println(department.getDdesc());
		this.departmentService.save(department);
		return "saveSuccess";
	}
	
	public String saveUI(){
		return "saveUI";
	}
	
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	public String update(){
		this.departmentService.update(department);
		return "updateSuccess";
	}
	
	public String delete(){
		/*System.out.println(department.getDid());
		System.out.println(department.getDname());
		System.out.println(department.getDdesc());*/
		//���ҵ�����ٽ���ɾ������ʵ�ּ���ɾ��
		department = this.departmentService.findById(department.getDid());
		this.departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
