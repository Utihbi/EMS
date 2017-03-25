package com.loogeoustc.ems.dao;

import java.util.List;

import com.loogeoustc.ems.domain.Employee;

public interface EmployeeDao {
	public Employee findByUsernameAndPassword(Employee emloyee);

	public List<Employee> findByPage(Integer begin,Integer size);

	public int findCount();

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);

	public void save(Employee employee);
}
