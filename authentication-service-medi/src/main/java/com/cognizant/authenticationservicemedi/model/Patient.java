package com.cognizant.authenticationservicemedi.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
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
	@Column(name="mail_id")
	String emailid;
	@Column(name="password")
	String password;
	@Column(name="address_line_1")
	String address1;
	@Column(name="address_line_2")
	String address2;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="zip_code")
	BigDecimal zipcode;
	@Column(name="flag")
	boolean flag;
	@ManyToMany
	@JoinTable(name="medical_test_history",joinColumns=@JoinColumn(name="patient_id_fk"),inverseJoinColumns=@JoinColumn(name="doctor_id_fk"))
	List<Doctor> doctorlist;

	
	public List<Doctor> getDoctorlist() {
		return doctorlist;
	}
	public void setDoctorlist(List<Doctor> doctorlist) {
		this.doctorlist = doctorlist;
	}
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BigDecimal getZipcode() {
		return zipcode;
	}
	public void setZipcode(BigDecimal zipcode) {
		this.zipcode = zipcode;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", contactnumber=" + contactnumber + ", altcontactnumber="
				+ altcontactnumber + ", emailid=" + emailid + ", password=" + password + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", flag="
				+ flag + ", medicalTestHistories=" + doctorlist  + "]";
	}
	public Patient(int id, String firstname, String lastname, int age, String gender, Date dob,
			BigDecimal contactnumber, BigDecimal altcontactnumber, String emailid, String password, String address1,
			String address2, String city, String state, BigDecimal zipcode, boolean flag) {
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
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.flag = flag;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
