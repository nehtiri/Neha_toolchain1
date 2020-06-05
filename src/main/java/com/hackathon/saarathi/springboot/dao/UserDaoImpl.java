package com.hackathon.saarathi.springboot.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hackathon.saarathi.springboot.entity.User;
import com.hackathon.saarathi.springboot.mapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<User> findAll() {
		return template.query("select * from user_details", new UserRowMapper());
	}
	@Override
	public void insertUser(User emp) {
		
		final String sql = "insert into user_details(lastName,firstName,phoneNumber,password,email,category) values(:lastName,:firstName,:phoneNumber,:password,:email,:category)";
		 
		System.out.println("sql "+sql + " emp  "+emp.toString());	
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					
	        		.addValue("lastName", emp.getLastName())
					.addValue("firstName", emp.getFirstName())
					.addValue("phoneNumber", emp.getPhoneNumber())
					.addValue("password", emp.getPassword())
					.addValue("category", emp.getCategory())
			.addValue("email", emp.getEmail());


	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateUser(User emp) {
		 final String sql = "update user_details set lastName=:lastName,firstName=:firstName,phoneNumber=:phoneNumber,password=:password,email=:email,category=:category where userId=:userId";
		 
		 
		 
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("lastName", emp.getLastName())
					.addValue("firstName", emp.getFirstName())
					.addValue("phoneNumber", emp.getPhoneNumber())
					.addValue("password", emp.getPassword())
					.addValue("category", emp.getCategory())
					.addValue("email", emp.getEmail());
		
					template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateUser(User user) {
		 final String sql = "update user_details set lastName=:lastName,firstName=:firstName,phoneNumber=:phoneNumber,password=:password,email=:email,category=:category where userId=:userId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("userId", user.getUserId());

		 
		 map.put("lastName", user.getLastName());
			map.put("firstName", user.getFirstName());
			map.put("phoneNumber", user.getPhoneNumber());
			map.put("password", user.getPassword());
			map.put("category", user.getCategory());
			map.put("email", user.getEmail());
			
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteUser(User user) {
		 final String sql = "delete from user_details where userId=:userId";
			 

		 Map<String,Object> map = new HashMap<String,Object>();  
		 map.put("userId", user.getUserId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	@Override
	public List<User> getUsersByCategory(String category) {
		 final String sql = "select * from user_details where category='"+category+"'";
	
		 System.out.println("sql "+sql);
		 return template.query(sql, new UserRowMapper());

		 
	}
	
}
