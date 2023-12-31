package com.backend.ListsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ListsApp.entities.TasksList;
import com.backend.ListsApp.entities.User;
import com.backend.ListsApp.services.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/get")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/update")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@GetMapping("/getTasksList/{id}") 
	public List<TasksList> getTasksListByUser(@PathVariable Long id) {
		return userService.getTaskListByUser(id);
	}
}

