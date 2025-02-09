package com.cognizant.authenticationservicemedi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservicemedi.exception.UserAlreadyExists;
import com.cognizant.authenticationservicemedi.service.LoginService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/admin/{name}/{pwd}")
	public boolean authenticateadmin(@PathVariable String name,@PathVariable String pwd) throws UserAlreadyExists {
		//This is a test
		return loginService.authenticateadmin(name,pwd);
	}

	@GetMapping("/patient/{name}/{pwd}")
	public boolean authenticatePatient(@PathVariable String name,@PathVariable String pwd) throws UserAlreadyExists {
		return loginService.authenticatePatient(name,pwd);
	}

	@GetMapping("/doctor/{name}/{pwd}")
	public boolean authenticateDoctor(@PathVariable String name,@PathVariable String pwd) throws UserAlreadyExists {
		return loginService.authenticateDoctor(name,pwd);
	}


}
