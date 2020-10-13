package com.yabim.ets.service;

import java.util.List;

import com.yabim.ets.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(int employeeId);

	public void deleteEmployee(int employeeId);
}
