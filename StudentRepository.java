package com.surya.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Integer>{

    List<Student> findAllByPlaceInAndAge(List<String> places, Integer age);
	

	}


