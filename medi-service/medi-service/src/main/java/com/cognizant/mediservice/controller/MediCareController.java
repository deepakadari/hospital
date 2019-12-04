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
import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MediCare;
import com.cognizant.mediservice.service.MediCareService;



@RestController
@CrossOrigin
@RequestMapping("/medicare")
public class MediCareController {
	@Autowired
	MediCareService mediCareService;

	@GetMapping
	public List<Doctor> getallmedicare() {
		return mediCareService.getallmedicare();

	}
//updated
	@GetMapping("/{id}")
	public MediCare getallmedicare(@PathVariable int id) {
		return mediCareService.getallmedicareById(id);

	}
	@PutMapping()
	public ResponseTransfer updatemedicare(@RequestBody MediCare medicare) {
		 
		String msg=mediCareService.updatemedicare(medicare);
 
		 return new ResponseTransfer(msg);
	}

}
