package com.hackathon.saarathi.springboot.controller;

import java.util.List;




import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.CloudantClient;
import com.hackathon.saarathi.springboot.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	CloudantClient 	cloudantClient;
	
	
	@GetMapping(value = "/userList")
	public String getUsers() {
		
		System.out.println("Hello");
		//return userService.findAll();
		List<String> list = null;
		try
		{
		 list = cloudantClient.getAllDbs();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Your cloudant application is running with "+list;
	}
	
	
	
	/*@GetMapping(value = "/getUsersByCategory")
	public List<User> getUsersByCategory(@RequestParam String category) {
		return userService.getUsersByCategory(category);
	
	}
	
	@PostMapping(value = "/createUser")
	public void createUser(@RequestBody User emp) {
		 userService.insertUser(emp);
	
	}
	@PutMapping(value = "/updateUser")
	public void updateUser(@RequestBody User emp) {
		 userService.updateUser(emp);
	
	}
	@PutMapping(value = "/executeUpdateUser")
	public void executeUpdateUser(@RequestBody User emp) {
		 userService.executeUpdateUser(emp);
	
	}
	
	@DeleteMapping(value = "/deleteUserById")
	public void deleteUser(@RequestBody User emp) {
		 userService.deleteUser(emp);
	
	}
	*/
	
}
