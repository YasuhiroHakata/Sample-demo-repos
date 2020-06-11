package com.example.demo.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.hello.domain.model.EmployeeForm;
import com.example.demo.hello.domain.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/hello")
	public String getHello(@ModelAttribute EmployeeForm form) {
		return "hello";
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
		model.addAttribute("sample", str);
		return "helloResponse";
	}

	@PostMapping("/hello/db")
	//	public String postDbRequest(@RequestParam("text2") String str, Model model) {
	public String postDbRequest(@Validated @ModelAttribute EmployeeForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return getHello(form);
		}

		EmployeeForm employee = helloService.findOut(form.getEmployeeId());
		if (employee != null) {
			model.addAttribute("id", employee.getEmployeeId());
			model.addAttribute("name", employee.getEmployeeName());
			model.addAttribute("age", employee.getAge());
		}
		return "helloResponseDB";
	}

}
