package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("in ctor"+getClass());
	}	
	
	@PostMapping("/SignUp")
	public ResponseEntity<?> register(@RequestBody UserDTO user){
		System.out.println("in add User "+user);
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
		}catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@PostMapping("/SignIn")
	public ResponseEntity<?> signIn(@RequestBody AuthDTO dto){
		System.out.println("In SignIn"+dto);
		
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userSignIn(dto));
		}catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
	}

}
