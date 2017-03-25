package com.loogeoustc.ems.service;

import com.loogeoustc.ems.domain.Employee;
import com.loogeoustc.ems.domain.PageBean;

/*
 * Ա�������ҵ���ӿ�
 */
public interface EmployeeService {
	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(Integer currPage);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);

	public void save(Employee employee);
}
