package com.cognizant.mediservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mediservice.model.MedicalTestHistory;
import com.cognizant.mediservice.repository.MedicalTestHistoryRepository;



@Service
public class MedicalTestHistoryService {
	@Autowired
	MedicalTestHistoryRepository historyRepository;
	public List<MedicalTestHistory> getall(){
		return historyRepository.findAll();
	}
}
