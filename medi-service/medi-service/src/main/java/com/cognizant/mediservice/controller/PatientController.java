package com.cognizant.mediservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.repository.PatientRepository;
import com.cognizant.mediservice.service.PatientService;



@RestController
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@Autowired
	PatientRepository patientRepository;

	@PostMapping("/booking/{patientname}/{doctorid}")
	MedicalTestHistory bookingmedicare(@RequestBody MedicalTestHistory history,@PathVariable String patientname, @PathVariable int doctorid) {
		return patientService.bookingmedicare(history,patientname, doctorid);

	}
	@GetMapping("/booking/{patientname}")
	List<Doctor> bookingStatus(@PathVariable String patientname){
		return patientService.bookingStatus(patientname);
	}
	//updated
	@GetMapping("/bookings/{patientname}")
	public List<MedicalTestHistory> getBookingStatusByPatientName(@PathVariable String patientname){
		return patientService.getBookingStatusByPatientName(patientname);
	}
	
	@GetMapping("/{doctorname}")
	String getMsByDoctorName(@PathVariable(value="doctorname") String name)
	{
		//System.err.println(patientService.getMsByDoctorName(name));
		return patientService.getMsByDoctorName(name);
	}
	
	//trail
	@GetMapping("/report1/{user}")
	public List<MedicalTestHistory> getReportByPatientName(@PathVariable(value="user") String name) {
		return patientService.getReportByPatientName(name);
	}
	
	@GetMapping("/testby/{doctorid}")
	public MedicalTestHistory getReportByDoctorId(@PathVariable(value="doctorid") int doctorid){
		return patientService.getReportByDoctorId(doctorid);
		
	}
	
/*	@GetMapping("/reportid/{reportid}") 
	public Patient patientDetailbyreportId(@PathVariable(value="reportid") int reportid){
		return patientRepository.patientDetailbyreportId(reportid);
	}*/
	
	
	
	//u[pdated
	@GetMapping("/report/{id}/{name}")
	public List<MedicalTestHistory> getReportByPatientid(@PathVariable int id,@PathVariable String name) {
		return patientService.getReportByPatientid(id,name);
	}
	
}
