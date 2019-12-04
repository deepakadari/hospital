package com.cognizant.authenticationservicemedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservicemedi.exception.UserAlreadyExists;
import com.cognizant.authenticationservicemedi.model.Admin;
import com.cognizant.authenticationservicemedi.model.Doctor;
import com.cognizant.authenticationservicemedi.model.Patient;
import com.cognizant.authenticationservicemedi.repository.AdminLoginRepository;
import com.cognizant.authenticationservicemedi.repository.DoctorLoginRepository;
import com.cognizant.authenticationservicemedi.repository.PatientLoginRepository;
import com.cognizant.authenticationservicemedi.service.SignUpService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/signup")
public class SignUpController {

	
	@Autowired
	AdminLoginRepository rep;
	@Autowired
	PatientLoginRepository p;
	
	@Autowired
	DoctorLoginRepository doc;
	
	@Autowired
	SignUpService signUpService;
	@PostMapping("/admin")
	public Admin AdminSignUp(@RequestBody Admin admin) throws UserAlreadyExists {
		return signUpService.AdminSignUp(admin);
	}
	@PostMapping("/patient")
	public Patient PatientSignUp(@RequestBody Patient patient) throws UserAlreadyExists{
		return signUpService.PatientSignUp(patient);
	}
	@PostMapping("/doctor")
	public Doctor DoctorSignUp(@RequestBody Doctor doctor) throws UserAlreadyExists{
		return signUpService.DoctorSignUp(doctor);
	}
	
	@GetMapping
	public Admin get() {
		return rep.getbyadminname("abhi");
	}
	@GetMapping("/p")
	public Patient getpatient() {
		return p.getbyPatientname("venuqqq");
	}
	@GetMapping("/d")
	public Doctor getDoctor() {
		return doc.getbyDoctorname("Dr.Venu");
	}
}
