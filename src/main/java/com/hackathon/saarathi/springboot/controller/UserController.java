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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;
import com.hackathon.saarathi.springboot.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	CloudantClient 	cloudantClient;
	
	@Autowired
	Database db;
	
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
	

	@PostMapping(value = "/getAllUsers")
	public @ResponseBody String createUser() {

		User user = new User();

		user.setFirstName("Jaya");
		user.setFirstName("wagaskar");
		user.setUserId(1l);

		System.out.println("Save Review " + user);
		
		com.cloudant.client.api.model.Response r = null;
		if (user != null) {
			r = db.post(user);
		}
		
		return "user created  with id"+r.getId();
	}
	
	@GetMapping(value = "/getAllUsers")
	public @ResponseBody List getAll(@RequestParam(required = false) Long userId) {
		// Get all documents from socialreviewdb
		List allDocs = null;
		try {
			if (userId == null) {
				allDocs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(User.class);
			} else {
				// create Index
				// Create a design doc named designdoc
				// A view named querybyitemIdView
				// and an index named itemId
				db.createIndex("querybyitemIdView", "designdoc", "json",
						new IndexField[] { new IndexField("userId", SortOrder.asc) });
				System.out.println("Successfully created index");
				allDocs = db.findByIndex("{\"userId\" : " + userId + "}", User.class);
			}
		} catch (Exception e) {
			System.out.println("Exception thrown : " + e.getMessage());
		}
		return allDocs;
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
