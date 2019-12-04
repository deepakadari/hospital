package com.cognizant.authenticationservicemedi.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservicemedi.exception.UserAlreadyExists;
import com.cognizant.authenticationservicemedi.model.Admin;
import com.cognizant.authenticationservicemedi.model.Doctor;
import com.cognizant.authenticationservicemedi.model.Patient;
import com.cognizant.authenticationservicemedi.repository.AdminLoginRepository;
import com.cognizant.authenticationservicemedi.repository.DoctorLoginRepository;
import com.cognizant.authenticationservicemedi.repository.MedicareRepository;
import com.cognizant.authenticationservicemedi.repository.PatientLoginRepository;


@Service
public class SignUpService {

	@Autowired
	AdminLoginRepository adminRepository;
	@Autowired
	PatientLoginRepository patientLoginRepository;
	@Autowired
	DoctorLoginRepository doctorLoginRepository;
	@Autowired
	MedicareRepository medicareRepository;

	@Transactional
	public Admin AdminSignUp(Admin admin1) throws UserAlreadyExists {

		Optional<Admin> adminList = adminRepository.getbyadminnameop(admin1.getFirstname());
		System.err.println(adminList);
		if (adminList.isPresent()) {
			throw new UserAlreadyExists();
		} else {
			return adminRepository.save(admin1);
		}

	}

	@Transactional
	public Patient PatientSignUp(Patient patient) throws UserAlreadyExists {

		Optional<Patient> patientList = patientLoginRepository.getbyPatientnameop(patient.getFirstname());
		System.err.println(patientList);
		if (patientList.isPresent()) {
			throw new UserAlreadyExists();
		} else {
			return patientLoginRepository.save(patient);
		}

	}

	public Doctor DoctorSignUp(Doctor doctor) throws UserAlreadyExists {
		
		Optional<Doctor> dOptional=doctorLoginRepository.getbyDoctornameop(doctor.getFirstname());
		System.err.println(dOptional);
		if(dOptional.isPresent()){
			throw new UserAlreadyExists();
		}
		else{
			return doctorLoginRepository.save(doctor);
		}
		// TODO Auto-generated method stub
		//Doctor doc = doctorLoginRepository.getbyDoctorname(doctor.getFirstname());
		
		/*List<Doctor> doctors = doctorLoginRepository.findAll();
		MediCare mediCareeee=medicareRepository.getOne(doctor.getMedicareservice().getMedicareServiceid());
		//MediCare care2 = doctor.getMedicareservice();
		
		System.err.println(mediCareeee);
		for (Doctor doctor2 : doctors) {
			
			MediCare care = doctor2.getMedicareservice();
			
			if (doctor2.getFirstname().equals(doctor.getFirstname())) {
				throw new UserAlreadyExists();
			} else {
				if (mediCareeee.getMedicareServiceid() == care.getMedicareServiceid()) {
					throw new UserAlreadyExists();
				} else {
					return doctorLoginRepository.save(doctor);
				}

			}
		}
		return null;
		// MediCare care=docto.getMedicareservice();
		// care.getMedicareServiceid();
		// System.err.println(doctorList);
		// if(!doctorList.getFirstname().isEmpty()){
		// throw new UserAlreadyExists();
		// }
		// else{
		// return doctorLoginRepository.save(doctor);
		// }*/
		
	}

}
