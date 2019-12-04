package com.cognizant.mediservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.mediservice.model.Admin;
import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.Patient;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query(value="select p from Patient p where p.flag=:val")
	public List<Patient> getallpatient(@Param(value = "val") boolean flag);
	@Query(value="select d from Doctor d where d.flag=:val")
	public List<Doctor> getalldoctor(@Param(value = "val") boolean flag);
	

}
