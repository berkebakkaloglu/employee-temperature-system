package com.yabim.ets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yabim.ets.dao.EmployeeDAO;
import com.yabim.ets.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		Employee employee = employeeDAO.getEmployee(employeeId);

		return employee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

}
