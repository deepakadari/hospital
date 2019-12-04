package com.cognizant.mediservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MediCare;
import com.cognizant.mediservice.repository.DoctorRepository;
import com.cognizant.mediservice.repository.MedicareRepository;


@Service
public class MediCareService {
	@Autowired
	MedicareRepository medicareRepository;
	@Autowired
	DoctorRepository doctorRepository;

	public List<Doctor> getallmedicare() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	public MediCare getmedicarebyname(String doctorname) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.getOne(doctorname);
		
		return doctor.getMedicareservice();
	}

	public MediCare modifymedicare(MediCare mediCare,String doctorname) {
		// TODO Auto-generated method stub
		MediCare m= getmedicarebyname(doctorname);
		if(m.getMedicareServiceid()==mediCare.getMedicareServiceid()){
		return medicareRepository.save(mediCare);
		}
		return medicareRepository.save(m);
	}
	
	//updated
	public MediCare getallmedicareById(int id) {
		// TODO Auto-generated method stub
		return medicareRepository.findById(id).get();
	}

	public String updatemedicare(MediCare medicare) {
		// TODO Auto-generated method stub
		medicareRepository.save(medicare);
		return "updated Successfully";
	}
	
}
