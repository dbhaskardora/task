package com.sdetails.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sdetails.restapi.entity.Student;
import com.sdetails.restapi.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student postDetails(@RequestBody Student student)
	{
		return studentService.saveDetails(student);
	}
	
	@GetMapping("/getById/{id}")
	public Student fetchDetailsById(@PathVariable int id)
	{
		return studentService.getStudentDetailsById(id);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getDetails()
	{
		return studentService.getAllDetails();
	}
	
	@DeleteMapping("/deleteStudentId/{id}")
	public String deleteDetails(@PathVariable int id)
	{
		return studentService.getDeleteById(id);
	}
}
