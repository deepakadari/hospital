package com.cognizant.authenticationservicemedi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservicemedi.exception.UserAlreadyExists;
import com.cognizant.authenticationservicemedi.model.Admin;
import com.cognizant.authenticationservicemedi.model.Doctor;
import com.cognizant.authenticationservicemedi.model.Patient;
import com.cognizant.authenticationservicemedi.repository.AdminLoginRepository;
import com.cognizant.authenticationservicemedi.repository.DoctorLoginRepository;
import com.cognizant.authenticationservicemedi.repository.PatientLoginRepository;



@Service
public class LoginService {
@Autowired
AdminLoginRepository adminLoginRepository;
@Autowired
PatientLoginRepository patientLoginRepository;
@Autowired
DoctorLoginRepository doctorLoginRepository;
public boolean authenticateadmin(String name, String pwd) throws UserAlreadyExists {
		// TODO Auto-generated method stub
	try{	
	Admin admin=adminLoginRepository.getbyadminname(name);
		 System.err.println(admin);
		 if(admin.getPassword().equals(pwd)){
			 return true;
		 }
		 else{
			 return false;
		 }
	} 
	catch (Exception e) {
		throw new UserAlreadyExists();// TODO: handle exception
	}
	}
	public boolean authenticatePatient(String name, String pwd) throws UserAlreadyExists {
		// TODO Auto-generated method stub
		try{
			Patient patient=patientLoginRepository.getbyPatientname(name);
		
		 if(patient.getPassword().equals(pwd)&& patient.isFlag()==true){
			 return true;
		 }
		 else{
			 return false;
		 }
		}
		catch (Exception e) {
			throw new UserAlreadyExists();// TODO: handle exception
		}
	}
	public boolean authenticateDoctor(String name, String pwd) throws UserAlreadyExists {
		// TODO Auto-generated method stub
		try{
		Doctor patient=doctorLoginRepository.getbyDoctorname(name);
		 if(patient.getPassword().equals(pwd)&&patient.isFlag()==true){
			 return true;
		 }
		 else{
			 return false;
		 }
		}
		catch (Exception e) {
			throw new UserAlreadyExists();// TODO: handle exception
		}
	}

}
