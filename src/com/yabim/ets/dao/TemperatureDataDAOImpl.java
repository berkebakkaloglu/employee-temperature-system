package com.yabim.ets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yabim.ets.entity.TemperatureData;

@Repository
public class TemperatureDataDAOImpl implements TemperatureDataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TemperatureData> getAllTemperatureData() {

		Session session = sessionFactory.getCurrentSession();

		Query<TemperatureData> query = session.createQuery("from TemperatureData order by date desc", TemperatureData.class);

		List<TemperatureData> allTemperatureData = query.getResultList();

		return allTemperatureData;
	}

	@Override
	public void saveTemperatureData(TemperatureData temperatureData) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(temperatureData);
	}

	@Override
	public TemperatureData getTemperatureDataByIdAndDate(int employeeId, String date) {

		Session session = sessionFactory.getCurrentSession();

		Query<TemperatureData> query = 
				session.createQuery("from TemperatureData where employeeId = " + employeeId + " and date = '" + date + "'", TemperatureData.class);

		TemperatureData temperatureData = query.getSingleResult();

		return temperatureData;
	}

	@Override
	public List<TemperatureData> getTemperatureDataByMaxTempAndDate(int maxTemperature, String date) {
		
		Session session = sessionFactory.getCurrentSession();

		Query<TemperatureData> query = 
				session.createQuery("from TemperatureData where temperatureInCelsius > " + maxTemperature + " and date = '" + date + "'", TemperatureData.class);

		List<TemperatureData> temperatureDataByMaxTempAndDate = query.getResultList();

		return temperatureDataByMaxTempAndDate;
	}

	
	@Override
	public void deleteTemperatureDataByIdAndDate(int employeeId, String date) {

		Session session = sessionFactory.getCurrentSession();

		Query<TemperatureData> query = 
				session.createQuery("from TemperatureData where employee_id = " + employeeId + " and date = '" + date + "'", TemperatureData.class);

		TemperatureData temperatureData = query.getSingleResult();

		session.delete(temperatureData);
	}

}
