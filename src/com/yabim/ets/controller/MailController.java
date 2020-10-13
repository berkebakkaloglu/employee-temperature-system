package com.yabim.ets.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yabim.ets.entity.EmailConfiguration;
import com.yabim.ets.entity.TemperatureData;
import com.yabim.ets.service.EmployeeService;
import com.yabim.ets.service.TemperatureDataService;

@RestController
@RequestMapping("/temperatureData/mail")
public class MailController {

	private EmailConfiguration emailConfiguration;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TemperatureDataService temperatureDataService;

	public MailController(EmailConfiguration emailConfiguration) {
		this.emailConfiguration = emailConfiguration;
	}

	@PostMapping("/send")
	public void sendTemperatureMail(
			@RequestParam("maxTemperature") int maxTemperature, @RequestParam("date") String date,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		List<TemperatureData> temperatureDataByMaxTempAndDate 
		= temperatureDataService.getTemperatureDataByMaxTempAndDate(maxTemperature, date);

		JavaMailSenderImpl mailSender = configureMailSender();

		configureAndSendCustomMail(temperatureDataByMaxTempAndDate, mailSender);
		
		response.sendRedirect((request.getContextPath() + "/temperatureData/list"));
	}

	private JavaMailSenderImpl configureMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(emailConfiguration.getHost());
		mailSender.setPort(emailConfiguration.getPort());
		mailSender.setUsername(emailConfiguration.getUsername());
		mailSender.setPassword(emailConfiguration.getPassword());

		return mailSender;
	}

	private void configureAndSendCustomMail(List<TemperatureData> temperatureDataByMaxTempAndDate,
			JavaMailSenderImpl mailSender) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();;
		simpleMailMessage.setFrom(mailSender.getHost());
		simpleMailMessage.setSubject("Daily Temperature Warning");

		for (TemperatureData temperatureData : temperatureDataByMaxTempAndDate) {

			int employeeId = temperatureData.getEmployeeId();
			String employeeName = employeeService.getEmployee(employeeId).getName();
			String employeeSurname = employeeService.getEmployee(employeeId).getSurname();
			int employeeTemperature = temperatureData.getTemperatureInCelsius();

			String employeeMail = employeeService.getEmployee(employeeId).getMailAddress();

			simpleMailMessage.setTo(employeeMail);
			simpleMailMessage.setText("Employee No: " + employeeId + " Name: " + employeeName + " " + employeeSurname
					+ "\n" + "Temperature: " + employeeTemperature + " is too high!");

			mailSender.send(simpleMailMessage);
		}
	}

}
