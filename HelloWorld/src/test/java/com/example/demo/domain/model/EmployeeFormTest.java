package com.example.demo.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.hello.domain.model.EmployeeForm;

@SpringBootTest
public class EmployeeFormTest {

	private EmployeeForm form = new EmployeeForm();

	@Test
	public void noErrorTest() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		form.setEmployeeId(1);
		Set<ConstraintViolation<EmployeeForm>> result = validator.validate(form);
		assertEquals(result.size(), 0);
	}

	@Test
	public void idErrorTest() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		form.setEmployeeId(-11);
		Set<ConstraintViolation<EmployeeForm>> result = validator.validate(form);
		assertEquals(result.size(), 1);
		assertEquals("数値を入力してください", result.iterator().next().getMessage());
	}

}
