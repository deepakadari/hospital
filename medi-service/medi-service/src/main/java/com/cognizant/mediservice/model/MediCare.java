package com.cognizant.mediservice.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Medicare_services")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MediCare {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicare_service_id")
	int medicareServiceid;
	@Column(name = "medicare_service")
	String medicareservice;
	@Column(name = "service_description")
	String servicedescription;
	@Column(name = "Amount")
	BigDecimal amount;
	@Column(name = "img_link")
	String imageLink;
	
	
	

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getMedicareServiceid() {
		return medicareServiceid;
	}

	public void setMedicareServiceid(int medicareServiceid) {
		this.medicareServiceid = medicareServiceid;
	}

	public String getMedicareservice() {
		return medicareservice;
	}

	public void setMedicareservice(String medicareservice) {
		this.medicareservice = medicareservice;
	}

	public String getServicedescription() {
		return servicedescription;
	}

	public void setServicedescription(String servicedescription) {
		this.servicedescription = servicedescription;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MediCare [medicareServiceid=" + medicareServiceid + ", medicareservice=" + medicareservice
				+ ", servicedescription=" + servicedescription + ", amount=" + amount + "]";
	}

	public MediCare(int medicareServiceid, String medicareservice, String servicedescription, BigDecimal amount) {
		super();
		this.medicareServiceid = medicareServiceid;
		this.medicareservice = medicareservice;
		this.servicedescription = servicedescription;
		this.amount = amount;
	}

	public MediCare() {
		super();
		// TODO Auto-generated constructor stub
	}

}
