package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.trySpring.Employee;
import com.example.demo.trySpring.HelloService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
	@Autowired
	private HelloService service;

	@Test
	public void findoutTest1() {
		Employee actual = service.findOut(1);
		assertNull(actual);
	}

	@Test
	public void findoutTest2() {
		Employee actual = service.findOut(0);
		assertNull(actual);
	}
}
