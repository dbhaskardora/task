package com.sdetails.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdetails.restapi.entity.Student;
import com.sdetails.restapi.repos.StudentRepos;

@Service
public class StudentService {
	@Autowired
	private StudentRepos studentRepos;
	
	public Student saveDetails(Student student) 
	{	
		return studentRepos.save(student);	
	}
	
	public Student getStudentDetailsById(int id) 
	{
		return  studentRepos.findById(id).orElse(null);
	}
	
	public String getDeleteById(int id) 
	{
	 studentRepos.deleteById(id);
	 return "deleted Sucessfully=" + id;
	}
	
	public List<Student> getAllDetails() 
	{
		return studentRepos.findAll();
	}
}
