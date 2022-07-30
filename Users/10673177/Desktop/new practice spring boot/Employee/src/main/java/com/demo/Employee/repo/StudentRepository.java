package com.demo.Employee.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.demo.Employee.Entity.Student;
import com.demo.Employee.Entity.Subject;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//native Query
	@Query(value = "SELECT * FROM Student WHERE admission_date >= :startDate AND admission_date <= :endDate ORDER BY user_name DESC", nativeQuery = true)
	List<Student> getAllBetweenDates(
			@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
			@Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end);
	
	
//JPA named Query
	@Query(value = "SELECT t FROM Student t where admissionDate BETWEEN :startDate AND :endDate ORDER BY t.admissionDate DESC")
	public List<Student> getAllBetweenDates2(@Param("startDate") Date startDate, @Param("endDate") Date endDate);



List<Student> findByAdmissionDateBetweenOrderByAdmissionDateDesc(Date startDate, Date endDate);

public List<Student> findByUserNameStartingWith(String name);

public Student findByUserNameAndSubject_SubName(String name,String subname);


//Student findByUserNameAndSubject_SubName(String name, String subname, Pageable pageable);



}
