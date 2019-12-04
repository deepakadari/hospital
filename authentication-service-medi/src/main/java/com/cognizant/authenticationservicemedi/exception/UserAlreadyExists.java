package com.cognizant.authenticationservicemedi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user doesnot exits")
public class UserAlreadyExists extends Exception {

	public UserAlreadyExists() {
		
		System.out.println("user doesnot exits");
	}

}
