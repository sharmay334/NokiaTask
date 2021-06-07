/*
 * Controller Author : Yash Sharma
 */
package com.nokia.nokiamain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.nokiamain.pojo.UserCreatePojo;
import com.nokia.nokiamain.pojo.UserUpdatePojo;
import com.nokia.nokiamain.service.UserService;

@RestController
@RequestMapping("/nokia/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody @Valid UserCreatePojo userPojo) {
		
		return ResponseEntity.ok(userService.createUser(userPojo));

	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody @Valid UserUpdatePojo userPojo) {
		
		return ResponseEntity.ok(userService.updateUser(userPojo));

	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam(required = true) Long id) {
		
		return ResponseEntity.ok(userService.deleteUser(id));

	}

}
