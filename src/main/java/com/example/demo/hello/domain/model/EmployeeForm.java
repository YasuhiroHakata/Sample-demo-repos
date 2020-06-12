package com.example.demo.hello.domain.model;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class EmployeeForm {

	@Min(message = "数値を入力してください", value = 0)
	private int employeeId;
	private String employeeName;
	private int age;

}
