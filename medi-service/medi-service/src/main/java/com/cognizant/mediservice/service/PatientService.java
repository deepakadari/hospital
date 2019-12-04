package com.cognizant.mediservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.model.Patient;
import com.cognizant.mediservice.repository.DoctorRepository;
import com.cognizant.mediservice.repository.MedicalTestHistoryRepository;
import com.cognizant.mediservice.repository.MedicareRepository;
import com.cognizant.mediservice.repository.PatientRepository;


@Service
public class PatientService {
@Autowired
MedicalTestHistoryRepository medicalTestHistoryRepository;
@Autowired
PatientRepository patientRepository;
@Autowired
DoctorRepository doctorRepository;
@Autowired
MedicareRepository mediCareRepository;
	public MedicalTestHistory bookingmedicare(MedicalTestHistory history,String patientname,int doctorid) {
		// TODO Auto-generated method stub
		Patient pt=patientRepository.getOne(patientname);
		
		history.setDoctorId(doctorid);
		history.setPatientId(pt.getId());
		//Doctor doc=doctorRepository.doctorbymediId(medicareid);
		//System.err.println(doc);
		System.err.println("pt===>"+pt+"------------");
		//pt.getDoctorlist().add(doc);-*/
		patientRepository.save(pt);
		System.err.println("pt===>"+pt+"------------");
		//MedicalTestHistory  history =medicalTestHistoryRepository.modifystatus(pt.getId(),doctorid);
		//history.setBookingstatus(1);
		return medicalTestHistoryRepository.save(history);
	}
	public List<Doctor> bookingStatus(String patientname) {
		// TODO Auto-generated method stub
		Patient pt=patientRepository.getOne(patientname);
		//List<MedicalTestHistory> histories= medicalTestHistoryRepository.bookingStatus(pt.getId());
		System.err.println("hgfdghfds"+pt);
		//List<Doctor> doctors=pt.getDoctorlist();
		List<Integer> doctorIds=medicalTestHistoryRepository.getdoctorIdByBookingStatus(pt.getId());
		System.err.println(doctorIds);
		List<Doctor> patientdetails=doctorRepository.findAllById(doctorIds);
		 return patientdetails;
	}
	
	
	//updated
	public List<MedicalTestHistory> getBookingStatusByPatientName(String patientname) {
		// TODO Auto-generated method stub
		//Patient pt=patientRepository.getOne(patientname);
		return medicalTestHistoryRepository.getBookingStatusByPatientName(patientname);
		
		
	}
	public String getMsByDoctorName(String name)
	{
		String mediCare = mediCareRepository.getMsByDoctorName(name);
		return mediCare;
	}
	//trail
	public List<MedicalTestHistory> getReportByPatientName(String name) {
		// TODO Auto-generated method stub
		return medicalTestHistoryRepository.getReportByPatientName(name);
	}
	public MedicalTestHistory getReportByDoctorId(int doctorid) {
		
		
		// TODO Auto-generated method stub
		return medicalTestHistoryRepository.getReportByDoctorId(doctorid);
	}
	
	
	public List<MedicalTestHistory> getReportByPatientid(int id,String name){
		Patient patient=patientRepository.getOne(name);
		List<MedicalTestHistory> medicalTestRecords=medicalTestHistoryRepository.getbyTestRecordBypatientIds(id,patient.getId());
		return medicalTestRecords;
	}
}
