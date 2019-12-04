package com.cognizant.authenticationservicemedi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservicemedi.model.Patient;



@Repository
public interface PatientLoginRepository extends JpaRepository<Patient, Integer> {
	@Query(value="select * from patient  where first_name=:val",nativeQuery=true)
	Patient getbyPatientname(@Param("val") String name);
	@Query(value="select * from patient  where first_name=:val",nativeQuery=true)
	Optional<Patient> getbyPatientnameop(@Param("val") String name);
}
