package com.example.demo.hello.domain.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.domain.model.EmployeeForm;
import com.example.demo.hello.domain.repository.HelloRepository;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;

	public EmployeeForm findOut(int id) {
		EmployeeForm employee = null;

		Map<String, Object> map = helloRepository.findOne(id);
		if (map != null && map.size() > 0) {
			int employeeId = (Integer) map.get("employee_id");
			String employeeName = (String) map.get("employee_name");
			int age = (Integer) map.get("age");
			employee = new EmployeeForm();
			employee.setEmployeeId(employeeId);
			employee.setEmployeeName(employeeName);
			employee.setAge(age);
		}
		return employee;
	}

}
