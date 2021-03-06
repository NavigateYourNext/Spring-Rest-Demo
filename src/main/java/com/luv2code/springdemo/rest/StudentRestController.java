package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	//Define @PostConstruct to load the student data... only once
	@PostConstruct
	public void loadData()
	{
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Akshay","Shete"));
		theStudents.add(new Student("Pradip","Shete"));
		theStudents.add(new Student("Sangita","Shete"));

	}

	@GetMapping("/students")
	public List<Student> getStudents()
	{	
		return theStudents;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		//Check the studentId against the list size
		if((studentId >= theStudents.size()) || (studentId < 0))
		{
			throw new StudentNotFoundException("Student Id Not Found - "+studentId);
		}

		return theStudents.get(studentId);
	}


}
