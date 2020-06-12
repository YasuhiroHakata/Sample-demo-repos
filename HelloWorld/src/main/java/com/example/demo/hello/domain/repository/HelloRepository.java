package com.example.demo.hello.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(int id) {
		Map<String, Object> employee = null;
		try {
			String query = "Select"
					+ " employee_id,"
					+ " employee_name,"
					+ " age"
					+ " From employee"
					+ " WHERE employee_id =?";

			employee = jdbcTemplate.queryForMap(query, id);
		} catch (DataAccessException e) {
			// 0件ヒット
		}
		return employee;

	}
}
