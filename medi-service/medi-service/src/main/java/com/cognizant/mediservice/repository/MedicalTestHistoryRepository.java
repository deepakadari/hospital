package com.cognizant.mediservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.mediservice.model.MedicalTestHistory;


@Repository
public interface MedicalTestHistoryRepository extends JpaRepository<MedicalTestHistory, Integer> {

@Query(value="select * from medical_test_history where booking_status=:val and doctor_id_fk=:val1",nativeQuery=true)
List<MedicalTestHistory> getbyBookingStatus(@Param("val") int val,@Param("val1") int val1);


@Query(value="select * from medical_test_history where patient_id_fk=:val and doctor_id_fk=:val1",nativeQuery=true)
MedicalTestHistory modifystatus(@Param("val") int patientid,@Param("val1") int id);

@Query(value="select * from medical_test_history where patient_id_fk=:val1",nativeQuery=true)
List<MedicalTestHistory> bookingStatus(@Param("val1") int patientname);

@Query(value="select * from medical_test_history where booking_status=:val1",nativeQuery=true)
List<MedicalTestHistory> getTestsByStatus(@Param("val1") int val1);

@Query(value="select * from medical_test_history where booking_status=2 and  patient_id_fk =(select patient_id from patient where first_name=:val)",nativeQuery=true)
List<MedicalTestHistory> getReportByPatientName(@Param("val") String val);


@Query(value="select * from medical_test_history where doctor_id_fk=:val",nativeQuery=true)
MedicalTestHistory getReportByDoctorId(@Param("val") int val);

//update query
@Query(value="select patient_id_fk  from medical_test_history where doctor_id_fk=:val1 and booking_status=:val2",nativeQuery=true)
List<Integer> getPatientIdByBookingStatus(@Param("val1") int docId,@Param("val2") int Bookstatus);

@Query(value="select * from medical_test_history where doctor_id_fk=:val1 and patient_id_fk=:val2 and booking_status=:val3",nativeQuery=true)
MedicalTestHistory modifyBookingStatusByIds(@Param("val1") int docId,@Param("val2") int patId,@Param("val3") int bookingStatus);


//@Query(value="select * from medical_test_history where doctor_id_fk=:val1 ",nativeQuery=true)
//MedicalTestHistoryService viewTestHistoryForDoctor();

@Query(value="select * from medical_test_history where doctor_id_fk=:val1 and patient_id_fk=:val2 and booking_status=:val3",nativeQuery=true)
List<MedicalTestHistory> getbyTestRecordByIds(@Param("val1") int docId,@Param("val2") int patId,@Param("val3") int bookingStatus);

@Query(value="select * from medical_test_history where patient_id_fk =(select patient_id from patient where first_name=:val)",nativeQuery=true)
List<MedicalTestHistory> getBookingStatusByPatientName(@Param("val") String val);

@Query(value="select doctor_id_fk from medical_test_history where  patient_id_fk=:val1 ",nativeQuery=true)
List<Integer> getdoctorIdByBookingStatus(@Param("val1") int id);

@Query(value="select * from medical_test_history where doctor_id_fk=:val1  and patient_id_fk=:val2",nativeQuery=true)
List<MedicalTestHistory> getbyTestRecordBypatientIds(@Param("val1") int patId,@Param("val2") int docId);



}
