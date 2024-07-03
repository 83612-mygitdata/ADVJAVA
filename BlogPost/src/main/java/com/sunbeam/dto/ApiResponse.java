package com.sunbeam.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	
	private String msg;
	private LocalDateTime timeStamp;
	
	public ApiResponse(String msg) {
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	

}
