package com.yabim.ets.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

	@Column(name="mail_address")
	private String mailAddress;

	public Employee() {

	}

	public Employee(int employeeId, String name, String surname, String mailAddress) {
		this.employeeId = employeeId;
		this.name = name;
		this.surname = surname;
		this.mailAddress = mailAddress;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", surname=" + surname + ", mailAddress="
				+ mailAddress + "]";
	}


}
