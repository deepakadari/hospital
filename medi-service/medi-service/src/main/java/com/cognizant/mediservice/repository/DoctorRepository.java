package com.cognizant.mediservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.mediservice.model.Doctor;



@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	/*@Query(value="select b from Booking b  where b.bookingstatus=:val")
    public List<Booking> getPatientStatusBystatusId(@Param ("val") int val);*/
	@Query(value="select d from Doctor d  where d.firstname=:val")
	public Doctor getOne(@Param ("val") String doctorname);
	@Query(value="Select * from doctor where medicare_services_id_fk=:value",nativeQuery=true)
	Doctor doctorbymediId(@Param("value") int value);
	
	@Query(value="Select count(*) from doctor where medicare_services_id_fk=:value",nativeQuery=true)
	public int countDcotorByMedicareId(@Param("value") int medicareServiceid);
	
	
}
