package com.sdetails.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdetails.restapi.entity.Student;

public interface StudentRepos extends JpaRepository<Student, Integer>{

}
