package com.sunbeam.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity{
	
	@Column(name="first_name",nullable= false)
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email", nullable= false, unique = true)
	private String email;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="passWord",nullable= false)
	private String passWord;
	
	@Column(name="role")
	private Role role;


}
