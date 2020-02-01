package com.switchcode.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.switchcode.springboot.thymeleafdemo.entity.Employee;
import com.switchcode.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService theEmployeeService;
	
	public EmployeeController (EmployeeService theEmployeeService)
	{
		this.theEmployeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployee (Model theModel){
	
		theModel.addAttribute("employees", theEmployeeService.findAll())	;
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee (Model theModel){
	
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee)	;
		return "employees/add-employees";
	}
	
	@PostMapping("/save")
	public String save (@ModelAttribute("employee") Employee theEmployee){
	
		theEmployeeService.save(theEmployee);
		
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee (@RequestParam("employeeId") int theId, Model theModel){
	
		Employee theEmployee = theEmployeeService.findById(theId);
		
		theModel.addAttribute("employee", theEmployee)	;
		return "employees/add-employees";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee (@RequestParam("employeeId") int theId, Model theModel){
	
		theEmployeeService.deleteById(theId);
		
	
		return "redirect:/employees/list";
	}

}
