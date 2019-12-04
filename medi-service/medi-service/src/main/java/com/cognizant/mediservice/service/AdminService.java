package com.cognizant.mediservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MediCare;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.model.Patient;
import com.cognizant.mediservice.repository.AdminRepository;
import com.cognizant.mediservice.repository.DoctorRepository;
import com.cognizant.mediservice.repository.MedicalTestHistoryRepository;
import com.cognizant.mediservice.repository.MedicareRepository;
import com.cognizant.mediservice.repository.PatientRepository;


@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	MedicalTestHistoryRepository medicalTestHistoryRepository;
	@Autowired
	MedicareRepository medicareRepository;

	public List<Patient> getallpatient(boolean flag) {
		// TODO Auto-generated method stub
		return adminRepository.getallpatient(flag);
	}

	public List<Doctor> getalldoctor(boolean flag) {
		// TODO Auto-generated method stub
		return adminRepository.getalldoctor(flag);
	}

	public Doctor acceptdoctor(int doctorid) {
		// TODO Auto-generated method stub
		Doctor doc = doctorRepository.getOne(doctorid);
		doc.getMedicareservice();
		System.err.println(doc.getMedicareservice());
		MediCare care = medicareRepository.getOne(doc.getMedicareservice().getMedicareServiceid());
		int count=doctorRepository.countDcotorByMedicareId(care.getMedicareServiceid());
		//mediCare=care;
		System.err.println(care);
		if (count>=2) {
			//mediCare.setMedicareServiceid(0);
			MediCare mediCare=new MediCare(0,care.getMedicareservice(),care.getServicedescription(),care.getAmount());
			medicareRepository.save(mediCare);

			int max = medicareRepository.getmaxid();
			doc.setFlag(true);
			doc.setMedicareservice(medicareRepository.getOne(max));

		}
		else{
			doc.setFlag(true);
		}
		return doctorRepository.save(doc);
	}

	public Patient acceptpatient(int patitentid) {
		// TODO Auto-generated method stub
		Patient pt = patientRepository.getOne(patitentid);
		pt.setFlag(true);
		return patientRepository.save(pt);
	}

	public void deletedoctor(int doctorid) {
		// TODO Auto-generated method stub

		doctorRepository.deleteById(doctorid);

	}

	public void deletepatient(int patitentid) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(patitentid);

	}

	public List<MedicalTestHistory> gettests(int flag) {
		return medicalTestHistoryRepository.getTestsByStatus(flag);
	}

	public MedicalTestHistory gettestbyId(int testid) {
		// TODO Auto-generated method stub
		return medicalTestHistoryRepository.getOne(testid);
	}

	public MedicalTestHistory modifytestresult(MedicalTestHistory history,int docf,int paf) {
		// TODO Auto-generated method stub
		System.err.println("histoeis"+history.toString());
		System.err.println("======>"+history.getPatientId());
		history.setPatientId(paf);
		history.setDoctorId(docf);
		//MedicalTestHistory con=new MedicalTestHistory(history.getId(), history.getServicedate(), history.getResultdate(), history.getActualvalue(),history.getNormalrange(),history.getDoctorcomments(), history.getOtherinfo());
		return medicalTestHistoryRepository.save(history);
	}
}
