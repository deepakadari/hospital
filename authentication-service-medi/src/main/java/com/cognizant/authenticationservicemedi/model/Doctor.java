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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
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
	@Column(name="degree")
	String degree;
	@Column(name="specialty")
	String specialty;
	@Column(name="work_hours")
	String workhours;
	@Column(name="hospital_name")
	String hospitalname;
	@Column(name="flag")
	boolean flag;
	@OneToOne
	@JoinColumn(name = "medicare_services_id_fk")
	MediCare medicareservice;
	@OneToMany
	@JoinColumn(name="doctor_id_fk")
	List<MedicalTestHistory> medicalTestHistories;
	public List<MedicalTestHistory> getMedicalTestHistories() {
		return medicalTestHistories;
	}
	public void setMedicalTestHistories(List<MedicalTestHistory> medicalTestHistories) {
		this.medicalTestHistories = medicalTestHistories;
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getWorkhours() {
		return workhours;
	}
	public void setWorkhours(String workhours) {
		this.workhours = workhours;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public MediCare getMedicareservice() {
		return medicareservice;
	}
	public void setMedicareservice(MediCare medicareservice) {
		this.medicareservice = medicareservice;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", contactnumber=" + contactnumber + ", altcontactnumber="
				+ altcontactnumber + ", emailid=" + emailid + ", password=" + password + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", degree=" + degree + ", specialty=" + specialty + ", workhours=" + workhours + ", hospitalname="
				+ hospitalname + ", flag=" + flag + ", medicareservice=" + medicareservice + "]";
	}
	public Doctor(int id, String firstname, String lastname, int age, String gender, Date dob, BigDecimal contactnumber,
			BigDecimal altcontactnumber, String emailid, String password, String address1, String address2, String city,
			String state, BigDecimal zipcode, String degree, String specialty, String workhours, String hospitalname,
			boolean flag) {
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
		this.degree = degree;
		this.specialty = specialty;
		this.workhours = workhours;
		this.hospitalname = hospitalname;
		this.flag = flag;
		
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
