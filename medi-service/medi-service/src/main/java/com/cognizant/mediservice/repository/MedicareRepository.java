package com.cognizant.mediservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.mediservice.model.MediCare;


@Repository
public interface MedicareRepository extends JpaRepository<MediCare , Integer> {
@Query(value="select max(medicare_service_id) from medicare_services",nativeQuery=true)
	int getmaxid();

@Query(value="select medicare_service from medicare_services where medicare_service_id = (select medicare_services_id_fk from doctor where first_name=:name)",nativeQuery=true)
//@Query(value="select medicare_service from medicare_services m join doctor d on m.medicare_service_id =d.medicare_services_id_fk where d.first_name=:name")
String getMsByDoctorName(@Param(value = "name") String name);

}
