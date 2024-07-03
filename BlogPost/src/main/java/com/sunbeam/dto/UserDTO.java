package com.sunbeam.dto;

import com.sunbeam.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
	
	private String first_name;
	private String last_name;
	private String email;
	private String dob;
	private String passWord;
	private Role role;

}
