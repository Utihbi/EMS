package com.loogeoustc.ems.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.loogeoustc.ems.dao.DepartmentDao;
import com.loogeoustc.ems.domain.Department;
import com.loogeoustc.ems.domain.PageBean;
import com.loogeoustc.ems.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();

		// ·â×°pageBean
		pageBean.setCurrPage(currPage);
		int pageSize = 3;
		pageBean.setPageSize(pageSize);

		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);

		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());

		int begin = (currPage - 1) * pageSize;

		List<Department> departments = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(departments);
		return pageBean;
	}

	@Override
	public void save(Department department) {
		this.departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		Department department = departmentDao.findById(did);
		return department;
	}

	@Override
	public void update(Department department) {
		this.departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		this.departmentDao.delete(department);
	}

	@Override
	public List<Department> findAll() {
		return this.departmentDao.findAll();
	}

}
