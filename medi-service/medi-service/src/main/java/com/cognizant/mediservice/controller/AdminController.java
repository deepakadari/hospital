package com.cognizant.mediservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.model.Patient;
import com.cognizant.mediservice.service.AdminService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping("/patient/{flag}")
	public List<Patient> getallpatient(@PathVariable boolean flag) {
		return adminService.getallpatient(flag);

	}
	@GetMapping("/doctor/{flag}")
	public List<Doctor> getalldoctor(@PathVariable boolean flag) {
		return adminService.getalldoctor(flag);

	}
	@PutMapping("/doctor/{doctorid}")
	public Doctor acceptdoctor(@PathVariable int doctorid){
		return adminService.acceptdoctor(doctorid);
	}
	@PutMapping("/patient/{patitentid}")
	public Patient acceptpatient(@PathVariable int patitentid){
		return adminService.acceptpatient(patitentid);
	}
	@DeleteMapping("/doctor/{doctorid}")
	public String deletedoctor(@PathVariable int doctorid){
		 adminService.deletedoctor(doctorid);
		 return "Deleted";
	}
	@DeleteMapping("/patient/{patitentid}")
	public String patientdoctor(@PathVariable int patitentid){
		 adminService.deletepatient(patitentid);
		 return "Deleted";
	}
	
	@GetMapping("/tests/{flag}")
	public List<MedicalTestHistory> gettests(@PathVariable int flag){
		return adminService.gettests(flag);
	}
	@GetMapping("/test/{testid}")
	public MedicalTestHistory gettestbyId(@PathVariable int testid){
		return adminService.gettestbyId(testid);	
	}
	@PutMapping("/test/{docf}/{paf}")
	public MedicalTestHistory modifytestresult(@RequestBody MedicalTestHistory history,@PathVariable int docf,@PathVariable int paf){
		return adminService.modifytestresult(history,docf,paf);
		
	}
}
