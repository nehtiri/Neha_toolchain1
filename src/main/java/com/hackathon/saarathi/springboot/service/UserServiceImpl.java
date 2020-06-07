package com.hackathon.saarathi.springboot.service;

import java.util.List;




import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hackathon.saarathi.springboot.dao.UserDao;
import com.hackathon.saarathi.springboot.model.User;

@Component
public class UserServiceImpl implements UserService{
	
	@Resource 
	UserDao userDao;
	
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	}
