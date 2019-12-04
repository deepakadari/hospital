package com.cognizant.authenticationservicemedi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservicemedi.model.Admin;


@Repository
public interface AdminLoginRepository extends JpaRepository<Admin, Integer> {
	@Query(value="select * from admin  where first_name=:val",nativeQuery=true)
	Admin getbyadminname(@Param("val") String name);
	
	@Query(value="select * from admin  where first_name=:val",nativeQuery=true)
	Optional<Admin> getbyadminnameop(@Param("val") String name);


}
