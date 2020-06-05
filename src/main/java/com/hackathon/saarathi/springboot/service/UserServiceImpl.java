package com.hackathon.saarathi.springboot.service;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hackathon.saarathi.springboot.dao.UserDao;
import com.hackathon.saarathi.springboot.entity.User;

@Component
public class UserServiceImpl implements UserService{
	@Resource 
	UserDao userDao;
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public void insertUser(User emp) {
		userDao.insertUser(emp);
		
	}
	@Override
	public void updateUser(User emp) {
		userDao.updateUser(emp);
		
	}
	@Override
	public void executeUpdateUser(User emp) {
		userDao.executeUpdateUser(emp);
		
	}

	@Override
	public void deleteUser(User emp) {
		userDao.deleteUser(emp);
		
	}

	@Override
	public List<User> getUsersByCategory(String category) {
		return userDao.getUsersByCategory(category);
	}
}
