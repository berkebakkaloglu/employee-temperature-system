package com.yabim.ets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yabim.ets.entity.TemperatureData;
import com.yabim.ets.service.TemperatureDataService;

@Controller
@RequestMapping("/temperatureData")
public class TemperatureDataController {

	@Autowired
	private TemperatureDataService temperatureDataService;

	@GetMapping("/list")
	public String listTemperatureData(Model model) {

		List<TemperatureData> allTemperatureData = temperatureDataService.getAllTemperatureData();

		model.addAttribute("allTemperatureData", allTemperatureData);

		return "list-temperature-data";
	}
	
	@GetMapping("/addTemperatureData")
	public String addTemperatureData(Model model) {

		TemperatureData temperatureData = new TemperatureData();

		model.addAttribute("temperatureData", temperatureData);

		return "temperature-data-form";
	}
	
	@PostMapping("/saveTemperatureData")
	public String saveTemperatureData(@ModelAttribute("temperatureData") TemperatureData temperatureData) {
		
		temperatureDataService.saveTemperatureData(temperatureData);
		
		return "redirect:/temperatureData/addTemperatureData";
	}
	
	@GetMapping("/updateTemperatureData")
	public String updateTemperatureData(@RequestParam("employeeId") int employeeId, @RequestParam("date") String date, Model model) {
		
		TemperatureData temperatureData = temperatureDataService.getTemperatureDataByIdAndDate(employeeId, date);
		
		model.addAttribute("temperatureData", temperatureData);
		
		return "temperature-data-form";
	}
	
	@GetMapping("/deleteTemperatureData")
	public String deleteTemperatureData(@RequestParam("employeeId") int employeeId, @RequestParam("date") String date) {
		
		temperatureDataService.deleteTemperatureDataByIdAndDate(employeeId, date);
		
		return "redirect:/temperatureData/list";
	}
}
