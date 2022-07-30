package com.demo.Employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Employee.Entity.Student;
import com.demo.Employee.Entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
	
 public List<Subject> findBySubNameStartingWith(String name);

}

