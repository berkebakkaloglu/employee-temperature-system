 package com.yabim.ets.entity;

import javax.persistence.*;

@Entity
@Table(name="temperature_data")
public class TemperatureData {

	@Id
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="date")
	private String date;

	@Column(name="temperature_in_celsius")
	private int temperatureInCelsius;

	public TemperatureData() {

	}

	public TemperatureData(int employeeId, String date, int temperatureInCelsius) {
		this.employeeId = employeeId;
		this.date = date;
		this.temperatureInCelsius = temperatureInCelsius;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTemperatureInCelsius() {
		return temperatureInCelsius;
	}

	public void setTemperatureInCelsius(int temperatureInCelsius) {
		this.temperatureInCelsius = temperatureInCelsius;
	}

	@Override
	public String toString() {
		return "TemperatureData [employeeId=" + employeeId + ", date="
				+ date + ", temperatureInCelsius=" + temperatureInCelsius + "]";
	}


}
