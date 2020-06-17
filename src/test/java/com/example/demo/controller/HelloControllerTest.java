package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * レスポンス200の確認
	 * @throws Exception
	 */
	@Test
	public void getHelloTest() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk());
	}

	/**
	 * 正しいHTML(タイトルが正しいか)が表示されているか
	 * @throws Exception
	 */
	@Test
	public void getHelloTest2() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(xpath("/html/head/title").string("Hello World"));
	}

	@Test
	public void postHelloTest() throws Exception {

		mockMvc.perform(post("/hello")
				.param("text1", "Hello Test"))
				.andExpect(status().isOk())
				.andExpect(xpath("/html/body/p").string("Hello Test"));
	}
}