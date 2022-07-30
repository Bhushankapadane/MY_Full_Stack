package com.demo.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Employee.Entity.Student;
import com.demo.Employee.Entity.Subject;
import com.demo.Employee.repo.SubjectRepository;

@Service
public class SubjectIMPL {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Subject saveSubject(Subject subject) {
		Subject stu = subjectRepository.save(subject);
		return stu;

	}
	
	

}
