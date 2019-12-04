package com.cognizant.authenticationservicemedi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservicemedi.model.MediCare;




@Repository
public interface MedicareRepository extends JpaRepository<MediCare , Integer> {
	
	@Query(value="select * from medicare_services  where medicare_service_id=:val",nativeQuery=true)
	MediCare getbymedicareid(@Param("val") int id);

}
