package com.sunbeam.custom_exception;

@SuppressWarnings("serial")
public class AuthException extends RuntimeException {
	public AuthException(String msg) {
		super(msg);
	}
}
