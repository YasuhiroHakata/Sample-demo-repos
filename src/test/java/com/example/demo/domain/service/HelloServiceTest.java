package com.example.demo.domain.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.hello.domain.model.EmployeeForm;
import com.example.demo.hello.domain.service.HelloService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService service;

    @Test
    public void findoutTest1() {
        EmployeeForm actual = service.findOut(1);
        assertNotNull(actual);
    }

    @Test
    public void findoutTest2() {
        EmployeeForm actual = service.findOut(0);
        assertNull(actual);
    }
}