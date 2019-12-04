package com.cognizant.authenticationservicemedi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservicemedi.model.Doctor;

@Repository
public interface DoctorLoginRepository extends JpaRepository<Doctor, Integer> {
	@Query(value="select * from doctor  where first_name=:val",nativeQuery=true)
	Doctor getbyDoctorname(@Param("val") String name);
	@Query(value="select * from doctor  where first_name=:val",nativeQuery=true)
	Optional<Doctor> getbyDoctornameop(@Param("val") String name);
}
