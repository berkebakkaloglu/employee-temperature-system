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

import com.yabim.ets.entity.Employee;
import com.yabim.ets.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employees = employeeService.getEmployees();

		model.addAttribute("employees", employees);

		return "list-employee";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.saveEmployee(employee);

		return "redirect:/employee/list";
	}

	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId") int employeeId, Model model) {

		Employee employee = employeeService.getEmployee(employeeId);

		model.addAttribute("employee", employee);

		return "employee-form";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId) {

		employeeService.deleteEmployee(employeeId);

		return "redirect:/employee/list";
	}

}
