package com.cognizant.mediservice.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="medical_test_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MedicalTestHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="report_id")
	int id;
	@Column(name="service_date")
	Date servicedate;
	@Column(name="result_date")
	Date resultdate;
	@Column(name="actual_value")
	Double actualvalue;
	@Column(name="normal_range")
	String normalrange;
	@Column(name="doctor_comments")
	String doctorcomments;
	
	@Column(name="other_info")
	String otherinfo;
	
	@Column(name="booking_status")
	Integer bookingstatus;
	
	@Column(name="patient_id_fk")
	int patientId;
	@Column(name="doctor_id_fk")
	int doctorId;
	/*@ManyToOne
	@JoinColumn(name="admin_id_fk")
	Admin adminId;*/

//	@ManyToOne
//	@JoinColumn(name="patient_id_fk")
//	Patient patientId;
//	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="doctor_id_fk",referencedColumnName="doctor_id")
//	Doctor doctorId;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getServicedate() {
		return servicedate;
	}

	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}

	public Date getResultdate() {
		return resultdate;
	}

	public void setResultdate(Date resultdate) {
		this.resultdate = resultdate;
	}

	public Double getActualvalue() {
		return actualvalue;
	}

	public void setActualvalue(Double actualvalue) {
		this.actualvalue = actualvalue;
	}

	public String getNormalrange() {
		return normalrange;
	}

	public void setNormalrange(String normalrange) {
		this.normalrange = normalrange;
	}

	public String getDoctorcomments() {
		return doctorcomments;
	}

	public void setDoctorcomments(String doctorcomments) {
		this.doctorcomments = doctorcomments;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public Integer getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(Integer bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	/*public Admin getAdminId() {
		return adminId;
	}

	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Doctor getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}*/



	public MedicalTestHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalTestHistory(int id, Date servicedate, Date resultdate, Double actualvalue, String normalrange,
			String doctorcomments, String otherinfo, int bookingstatus) {
		super();
		this.id = id;
		this.servicedate = servicedate;
		this.resultdate = resultdate;
		this.actualvalue = actualvalue;
		this.normalrange = normalrange;
		this.doctorcomments = doctorcomments;
		this.otherinfo = otherinfo;
		this.bookingstatus = bookingstatus;
	}

	
	public MedicalTestHistory(int id, Date servicedate, Date resultdate, Double actualvalue, String normalrange,
			String doctorcomments, String otherinfo) {
		super();
		this.id = id;
		this.servicedate = servicedate;
		this.resultdate = resultdate;
		this.actualvalue = actualvalue;
		this.normalrange = normalrange;
		this.doctorcomments = doctorcomments;
		this.otherinfo = otherinfo;
	}

	@Override
	public String toString() {
		return "MedicalTestHistory [id=" + id + ", servicedate=" + servicedate + ", resultdate=" + resultdate
				+ ", actualvalue=" + actualvalue + ", normalrange=" + normalrange + ", doctorcomments=" + doctorcomments
				+ ", otherinfo=" + otherinfo + ", bookingstatus=" + bookingstatus + "]";
	}


	
	
	
	
}
