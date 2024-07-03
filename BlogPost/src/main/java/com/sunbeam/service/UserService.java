package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthDTO;
import com.sunbeam.dto.UserDTO;


public interface UserService {
	
	ApiResponse addUser(UserDTO user);
	
	ApiResponse  userSignIn(AuthDTO dto);
	

}
