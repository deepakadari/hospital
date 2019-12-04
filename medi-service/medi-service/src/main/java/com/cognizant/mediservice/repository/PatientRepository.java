package com.cognizant.mediservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.mediservice.model.Doctor;
import com.cognizant.mediservice.model.Patient;



public interface PatientRepository extends JpaRepository<Patient, Integer> {
@Query(value="Select * from doctor where medicare_services_id_fk=:value",nativeQuery=true)
Doctor doctorbymediId(@Param("value") int value);

@Query(value="select d from Patient d  where d.firstname=:val")
Patient getOne(@Param("val") String patientid);


/*@Query(value="select * from patient where patient_id in (select patient_id_fk from medical_test_history where report_id=:val)",nativeQuery=true)
Patient patientDetailbyreportId(@Param("val") int reportid);

*/

}
