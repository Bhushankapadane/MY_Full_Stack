package com.demo.Employee.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.internal.util.compare.ComparableComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Employee.SearchDTO;
import com.demo.Employee.SearchDTO2;
import com.demo.Employee.Entity.Student;
import com.demo.Employee.repo.StudentRepository;
import com.demo.Employee.service.StudentIMPL;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	StudentIMPL studentimpl;

	@Autowired
	StudentRepository repo;

	@PostMapping("/student")
	public Student createUser(@Valid @RequestBody Student student) {
		return studentimpl.saveStudent(student);
	}

	@PostMapping("/find/date-between")
	public List<Student> findByDate(@RequestBody SearchDTO searcherDto) {

		LocalDateTime start = LocalDateTime.of(LocalDate.from(searcherDto.getStartdate()), LocalTime.of(0, 0, 0));
		LocalDateTime end = LocalDateTime.of(LocalDate.from(searcherDto.getEnddate()), LocalTime.of(23, 59, 59));

		List<Student> date = repo.getAllBetweenDates(start, end);
		return date;
	}

	@PostMapping("/find2/date-between")
	public List<Student> findByDate2(@RequestBody SearchDTO2 searcherDto2) {

		List<Student> date = repo.getAllBetweenDates2(searcherDto2.getStartdate(), searcherDto2.getEnddate());
		return date;

	}

	@PostMapping("/date-between")
	public List<Student> findByDateBetween(@RequestBody SearchDTO2 searcherDto2) {
		List<Student> date = repo.findByAdmissionDateBetweenOrderByAdmissionDateDesc(searcherDto2.getStartdate(),
				searcherDto2.getEnddate());
//		date.stream().map(d -> d.getUserName()).sorted(Comparator.reverseOrder()).collect(Collectors.toList())
//				.forEach(System.out::println);;
//		Comparator<Student>	comname=Comparator.comparing(Student::getAdmissionDate);
//	    date.sort(comname.reversed());
		return date;

	}

	@GetMapping("/getStudent")
	public Student GetstudentBySubjectName(@RequestParam String username, @RequestParam String subname) {
Student stu = repo.findByUserNameAndSubject_SubName(username, subname);

		return stu;

	}

}
