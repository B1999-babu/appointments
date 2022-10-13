package com.example.appointment.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.Entity.User;
import com.example.appointment.Exception.CustomException;
import com.example.appointment.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	//Create new User if that user is present it will throw the exception
	@PostMapping("/save")
	public ResponseEntity<User> save(User user)throws CustomException{
		return ResponseEntity.ok().body(userService.save(user));
	}
	
	
	// get user by his id
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<User>> getUserBy(@PathVariable("id") int id)throws CustomException{
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	
	//user can update his profile
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id")int id, User user)throws CustomException{
		return ResponseEntity.ok().body(userService.updateUser(user, id));
	}
}
