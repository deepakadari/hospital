package com.cognizant.mediservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.model.Patient;
import com.cognizant.mediservice.repository.DoctorRepository;
import com.cognizant.mediservice.repository.MedicalTestHistoryRepository;
import com.cognizant.mediservice.repository.PatientRepository;



@Service
public class DoctorService {
@Autowired
MedicalTestHistoryRepository medicalTestHistoryRepository;
@Autowired
DoctorRepository  doctorRepository;
@Autowired
PatientRepository patientRepository;

///////by docter name get all test history(in UI: view/update history in nav bar)
	public List<MedicalTestHistory> gettesthistorybydoctorname(String doctorname) {
		// TODO Auto-generated method stub
		Doctor doc=doctorRepository.getOne(doctorname);
		return doc.getMedicalTestHistories();
	}
	public Doctor gettestbydoctorname(String doctorname){
		Doctor doc=doctorRepository.getOne(doctorname);
		return doc;
	}

	public MedicalTestHistory modifytestresult(MedicalTestHistory history,String doctorname,int testid) {
		// TODO Auto-generated method stub
		Doctor doc=doctorRepository.getOne(doctorname);
		MedicalTestHistory medicalTest=doc.getMedicalTestHistories().get(testid-1);
		System.err.println(medicalTest);
		if(medicalTest.getId()==history.getId()){
			medicalTestHistoryRepository.save(history);
		}
		return medicalTestHistoryRepository.save(medicalTest);
	}

	public List<MedicalTestHistory> getbyBookingStatus(String doctorname, int statusid) {
		// TODO Auto-generated method stub
		Doctor doc=doctorRepository.getOne(doctorname);
		int id= doc.getId();
		List<MedicalTestHistory> histories=medicalTestHistoryRepository.getbyBookingStatus(statusid, id);
		
		System.err.println(histories);
		return histories;
	}
	
	
	////accept patient by doctor (send status 2 from angular)
	public MedicalTestHistory modifyBookingStatus(int bookingid, int bookingStatus) {
		// TODO Auto-generated method stub
		MedicalTestHistory medicalTestHistory =medicalTestHistoryRepository.getOne(bookingid);
		medicalTestHistory.setBookingstatus(bookingStatus);
		return medicalTestHistoryRepository.save(medicalTestHistory);
	}

public List<Patient> getPatientIdByBookingStatus(String doctorname,int status){
		
		Doctor doc=doctorRepository.getOne(doctorname);
		
		int id= doc.getId();
		List<Integer> patientIds=medicalTestHistoryRepository.getPatientIdByBookingStatus(id,status);
		List<Patient> patientdetails=patientRepository.findAllById(patientIds);
		
		
		System.err.println(patientdetails);
		
		return patientdetails;
	}
	public String modifyBookingStatusByIds(String doctorName, int patientId, int bookingStatus) {
	
		Doctor doc=doctorRepository.getOne(doctorName);
		System.err.println("docter Id"+doc.getId());
		
		MedicalTestHistory medicalTestHistory=medicalTestHistoryRepository.modifyBookingStatusByIds(doc.getId(), patientId,1);
		medicalTestHistory.setBookingstatus(bookingStatus);
		medicalTestHistoryRepository.save(medicalTestHistory);
		
		System.err.println("medicalTestHistory after edit status :::: "+medicalTestHistory);
		
		// TODO Auto-generated method stub
		return "Updated Successfully";
	}
	public List<MedicalTestHistory> getbyTestRecordByIds(String doctorname,int patientId,int statusid) {
		Doctor doc=doctorRepository.getOne(doctorname);
		List<MedicalTestHistory> medicalTestRecords=medicalTestHistoryRepository.getbyTestRecordByIds(doc.getId(),patientId,statusid);
		return medicalTestRecords;
	}

}
