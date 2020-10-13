package com.yabim.ets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yabim.ets.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {

		Session session = sessionFactory.getCurrentSession();

		Query<Employee> query = session.createQuery("from Employee order by employeeId asc", Employee.class);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployee(int employeeId) {

		Session session = sessionFactory.getCurrentSession();

		Employee employee = session.get(Employee.class, employeeId);

		return employee;
	}

	@Override
	public void deleteEmployee(int employeeId) {

		Session session = sessionFactory.getCurrentSession();

		Employee employee = session.get(Employee.class, employeeId);

		session.delete(employee);
	}


}
