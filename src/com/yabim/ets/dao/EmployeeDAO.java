package com.yabim.ets.dao;

import java.util.List;

import com.yabim.ets.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(int employeeId);

	public void deleteEmployee(int employeeId);
}
