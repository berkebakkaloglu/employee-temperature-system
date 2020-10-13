package com.yabim.ets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yabim.ets.dao.TemperatureDataDAO;
import com.yabim.ets.entity.TemperatureData;

@Service
public class TemperatureDataServiceImpl implements TemperatureDataService {

	@Autowired
	private TemperatureDataDAO temperatureDataDAO;

	@Override
	@Transactional
	public List<TemperatureData> getAllTemperatureData() {
		return temperatureDataDAO.getAllTemperatureData();
	}

	@Override
	@Transactional
	public void saveTemperatureData(TemperatureData temperatureData) {
		temperatureDataDAO.saveTemperatureData(temperatureData);
	}

	@Override
	@Transactional
	public TemperatureData getTemperatureDataByIdAndDate(int employeeId, String date) {
		TemperatureData temperatureData = temperatureDataDAO.getTemperatureDataByIdAndDate(employeeId, date);

		return temperatureData;
	}
	
	@Override
	@Transactional
	public List<TemperatureData> getTemperatureDataByMaxTempAndDate(int maxTemperature, String date) {
		return temperatureDataDAO.getTemperatureDataByMaxTempAndDate(maxTemperature, date);
	}

	@Override
	@Transactional
	public void deleteTemperatureDataByIdAndDate(int employeeId, String date) {
		temperatureDataDAO.deleteTemperatureDataByIdAndDate(employeeId, date);
	}

}
