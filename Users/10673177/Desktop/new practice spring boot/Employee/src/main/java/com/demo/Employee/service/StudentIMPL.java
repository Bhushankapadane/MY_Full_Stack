package com.demo.Employee.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.Employee.Entity.Student;
import com.demo.Employee.repo.StudentRepository;

@Service
public class StudentIMPL implements StudentRepository  {

	@Autowired
	StudentRepository repo;

public Student saveStudent(Student student) {
		Student stu = repo.save(student);
		return stu;

	}

@Override
public List<Student> findAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Student> findAll(Sort sort) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Student> findAllById(Iterable<Integer> ids) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> List<S> saveAll(Iterable<S> entities) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void flush() {
	// TODO Auto-generated method stub
	
}

@Override
public <S extends Student> S saveAndFlush(S entity) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteInBatch(Iterable<Student> entities) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteAllInBatch() {
	// TODO Auto-generated method stub
	
}

@Override
public Student getOne(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> List<S> findAll(Example<S> example) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Page<Student> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> S save(S entity) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Optional<Student> findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean existsById(Integer id) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public long count() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void deleteById(Integer id) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(Student entity) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteAll(Iterable<? extends Student> entities) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	
}

@Override
public <S extends Student> Optional<S> findOne(Example<S> example) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <S extends Student> long count(Example<S> example) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public <S extends Student> boolean exists(Example<S> example) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public List<Student> getAllBetweenDates(LocalDateTime start, LocalDateTime end) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Student> getAllBetweenDates2(Date startDate, Date endDate) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Student> findByAdmissionDateBetweenOrderByAdmissionDateDesc(Date startDate, Date endDate) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Student> findByUserNameStartingWith(String name) {
	// TODO Auto-generated method stub
	return null;
}


//@Override
//public Student findByUserNameAndSubject_SubName(String name, String subname , int pageNo,  int pageSize) {
//	 Pageable paging = PageRequest.of(pageNo, pageSize);
//	 
//	 repo.
//	return null;
//}

@Override
public Student findByUserNameAndSubject_SubName(String name, String subname) {
	// TODO Auto-generated method stub
	return null;
}





}
