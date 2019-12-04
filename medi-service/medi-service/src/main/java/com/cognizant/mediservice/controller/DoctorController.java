package com.cognizant.mediservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mediservice.ResponseTransfer;
import com.cognizant.mediservice.model.MediCare;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.model.Patient;
import com.cognizant.mediservice.service.AdminService;
import com.cognizant.mediservice.service.DoctorService;
import com.cognizant.mediservice.service.MediCareService;



@RestController
@CrossOrigin
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	MediCareService mediCareService;
	@Autowired
	AdminService adminService;
	@Autowired
	DoctorService doctorService;
	
	
	@GetMapping("/{doctorname}")
	public MediCare getmedicarebyname(@PathVariable String doctorname){
		
		return mediCareService.getmedicarebyname(doctorname);
		
	}
	@PutMapping("/{doctorname}")
	public MediCare modifymedicare(@RequestBody MediCare mediCare,@PathVariable String doctorname){
		return mediCareService.modifymedicare(mediCare,doctorname);
		
	}
	@GetMapping("/tests/{doctorname}/{statusid}")
	public List<MedicalTestHistory> gettestbydoctorname(@PathVariable String doctorname,@PathVariable int statusid)
	{
		return doctorService.getbyBookingStatus(doctorname,statusid);
	}
	@PutMapping("/tests/{doctorname}/{testid}")
	public MedicalTestHistory modifytestresult(@RequestBody MedicalTestHistory history,@PathVariable String doctorname,@PathVariable int testid){
		return doctorService.modifytestresult(history,doctorname,testid);
		
	}
    @GetMapping("/status1/{doctorname}/{statusid}")
    public List<MedicalTestHistory>  getbyBookingStatusRecord(@PathVariable String doctorname,@PathVariable int statusid) {
           return doctorService.getbyBookingStatus(doctorname,statusid);
    }
    @PutMapping("/status/{bookingid}/{bookingStatus}")
    public MedicalTestHistory modifyBookingStatus(@PathVariable int bookingid,@PathVariable int bookingStatus){
		return doctorService.modifyBookingStatus(bookingid,bookingStatus);
    	
    }
    
    
    
  //changed
    @GetMapping("/status/{doctorname}/{statusid}")
    public List<Patient>  getbyBookingStatus(@PathVariable String doctorname,@PathVariable int statusid) {
           return doctorService.getPatientIdByBookingStatus(doctorname,statusid);
    }
  
    
    @PutMapping("/status1/{doctorName}/{patientId}/{bookingStatus}")
    public ResponseTransfer modifyBookingStatusByIds(@PathVariable String doctorName,@PathVariable int patientId,@PathVariable int bookingStatus){
		
    	String msg= doctorService.modifyBookingStatusByIds(doctorName,patientId,bookingStatus);
    	
		return new ResponseTransfer(msg);
    }
    
    @GetMapping("/status2/{doctorname}/{patientId}/{statusid}")
    public List<MedicalTestHistory>  getbyTestRecordByIds(@PathVariable String doctorname,@PathVariable int patientId,@PathVariable int statusid) {
   
    	return doctorService.getbyTestRecordByIds(doctorname,patientId,statusid);
    }
}
