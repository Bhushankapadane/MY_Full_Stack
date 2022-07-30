package com.demo.Employee.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int Id;
	private String userName;
	private String emailId;
	private String mobileNumber;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date admissionDate; 
	 @OneToMany(mappedBy = "student", cascade = {
		        CascadeType.ALL
		    })
	private List<Subject> subject;
	
	
	public Student() {
		super();
		}
	
	public Student(int id, String userName, String emailId, String mobileNumber, Date admissionDate,
			List<Subject> subject) {
		super();
		Id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		admissionDate = admissionDate;
		this.subject = subject;
	}

	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		admissionDate = admissionDate;
	}
	public List<Subject> getSubject() {
		return subject;
	}
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	
	

}
