package com.hackathon.saarathi.springboot.mapper;

import java.sql.ResultSet;


import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hackathon.saarathi.springboot.model.User;


public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
	
	
		user.setFirstName(rs.getString("firstName"));
		
		user.setLastName(rs.getString("lastName"));
		user.setPhoneNumber(rs.getLong("phoneNumber"));
		user.setUserId(rs.getLong("userId"));

		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setCategory(rs.getString("category")); 

		return user;
	}


}
