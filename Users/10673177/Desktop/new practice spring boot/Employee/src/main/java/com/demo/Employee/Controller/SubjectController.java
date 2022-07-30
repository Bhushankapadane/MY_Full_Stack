package com.demo.Employee.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Employee.Entity.Student;
import com.demo.Employee.Entity.Subject;
import com.demo.Employee.repo.StudentRepository;
import com.demo.Employee.repo.SubjectRepository;
import com.demo.Employee.service.ResourceNotFoundException;

import com.demo.Employee.service.SubjectIMPL;


@RestController
@RequestMapping("/api/v1")
public class SubjectController {

  @Autowired
  SubjectIMPL SubjectIMPL;
  
 
  @Autowired
  SubjectRepository SubjectRepository;
  
  @Autowired
  StudentRepository StudentRepository;
  
 @PostMapping("/student/{stuid}/subject")
    public Subject createSubject( @PathVariable(value = "stuid") int studentid, @RequestBody Subject subject) throws ResourceNotFoundException {
	  return StudentRepository.findById(studentid).map(student -> {
		  subject.setStudent(student);
          return SubjectIMPL.saveSubject(subject);
	  }).orElseThrow(()-> new ResourceNotFoundException("subject not present")) ;
    }
 
 @GetMapping("/student/{name}")
 public List<Student> GetSubject( @PathVariable(value = "name") String  name) throws ResourceNotFoundException {
List<Student> sub=	StudentRepository.findByUserNameStartingWith(name);
return sub;
}
 
 @GetMapping("/subject/{name}")
 public List<Subject> GetallSubject( @PathVariable(value = "name") String  name) throws ResourceNotFoundException {
List<Subject> sub=	SubjectRepository.findBySubNameStartingWith(name);
return sub;
		
 }
}
