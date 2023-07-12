package com.bluebik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.model.User;
import com.bluebik.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("addUser")
	ResponseEntity<User> createUser(@RequestBody User user){
		User newUser=uService.createUser(user);
		return new ResponseEntity<>(newUser,HttpStatus.CREATED);
	}

}
