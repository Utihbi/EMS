package com.loogeoustc.ems.service;

import java.util.List;

import com.loogeoustc.ems.domain.Department;
import com.loogeoustc.ems.domain.PageBean;

public interface DepartmentService {
	public PageBean<Department> findByPage(Integer currPage);
	
	public void save(Department department);

	public Department findById(Integer did);

	public void update(Department department);

	public void delete(Department department);

	public List<Department> findAll();
}
