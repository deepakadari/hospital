package com.cognizant.authenticationservicemedi.model;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="admin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	int id;
	@Column(name="first_name")
	String firstname;
	@Column(name="last_name")
	String lastname;
	@Column(name="age")
	int age;
	@Column(name="gender")
	String gender;
	@Column(name="d_o_b")
	Date dob;
	@Column(name="contact_number")
	BigDecimal contactnumber;
	@Column(name="alt_contact_number")
	BigDecimal altcontactnumber;
	@Column(name="email_id")
	String emailid;
	@Column(name="password")
	String password;
/*	@OneToMany
	@JoinColumn(name="admin_id_fk")
	List<MedicalTestHistory> medicalTestHistories;
	
	
	public List<MedicalTestHistory> getMedicalTestHistories() {
		return medicalTestHistories;
	}
	public void setMedicalTestHistories(List<MedicalTestHistory> medicalTestHistories) {
		this.medicalTestHistories = medicalTestHistories;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public BigDecimal getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(BigDecimal contactnumber) {
		this.contactnumber = contactnumber;
	}
	public BigDecimal getAltcontactnumber() {
		return altcontactnumber;
	}
	public void setAltcontactnumber(BigDecimal altcontactnumber) {
		this.altcontactnumber = altcontactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", contactnumber=" + contactnumber + ", altcontactnumber="
				+ altcontactnumber + ", emailid=" + emailid + ", password=" + password + "]";
	}
	public Admin(int id, String firstname, String lastname, int age, String gender, Date dob, BigDecimal contactnumber,
			BigDecimal altcontactnumber, String emailid, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.contactnumber = contactnumber;
		this.altcontactnumber = altcontactnumber;
		this.emailid = emailid;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
