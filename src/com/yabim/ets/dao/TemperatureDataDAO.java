package com.yabim.ets.dao;

import java.util.List;

import com.yabim.ets.entity.TemperatureData;;

public interface TemperatureDataDAO {
	public List<TemperatureData> getAllTemperatureData();

	public void saveTemperatureData(TemperatureData temperatureData);

	public TemperatureData getTemperatureDataByIdAndDate(int employeeId, String date);
	
	public List<TemperatureData> getTemperatureDataByMaxTempAndDate(int maxTemperature, String date);

	public void deleteTemperatureDataByIdAndDate(int employeeId, String date);
}
