package com.demo.Employee.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject {
	@Id
	@GeneratedValue

	int subId;
	String subName;
	 @ManyToOne(cascade = CascadeType.ALL)
	//    @JoinColumn(name = "student_id")
	    @JsonIgnore
	    private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject() {
		super();
	}

	

	public Subject(int subId, String subName, Student student) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.student = student;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

}
