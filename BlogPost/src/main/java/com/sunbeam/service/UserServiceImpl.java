package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exception.AuthException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthDTO;
import com.sunbeam.dto.UserDTO;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addUser(UserDTO user) {
		
		User us =  mapper.map(user, User.class);
		userDao.save(us);
		
		return new ApiResponse("User is Added!!!"+us.getId());
	}

	@Override
	public ApiResponse userSignIn(AuthDTO dto) {
		
		User user =  userDao.findByEmailAndPassWord(dto.getEmail(), dto.getPassWord())
				.orElseThrow(()-> new AuthException("Invalid Email and Password!!!"));
		
		return new ApiResponse("Valid User!!!"+user);
	}
	

}
