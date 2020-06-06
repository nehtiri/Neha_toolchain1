package com.hackathon.saarathi.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.saarathi.springboot.model.User;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping(value = "/userList")
	public List<User> getUsers() {
		
		System.out.println("Hello");
		
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON file to Java object
		User obj = null;
		
		//ResourceUtils.getFile(
   // "classpath:data/employees.dat")
		try {
			obj = mapper.readValue(new ClassPathResource(
				      "data/User.json").getFile(), User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Arrays.asList(obj);
	
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
