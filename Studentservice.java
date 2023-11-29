package com.surya.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Studentservice {
	 @Autowired
	  private StudentRepository sr ;

	public List<Student> getall(List<String> places,Integer age) {
       List<Student> s=new ArrayList<>();
       if(places==null) {
       sr.findAll().forEach(Student->s.add(Student));
       }else {
    	 return sr.findAllByPlaceInAndAge(places,age); 
    	 
       }
		return s;
	}

	public Student sdetail(Student s) {
		return sr.save(s);
	}

	public Optional<Student> getbyid(Integer sid) {
		return sr.findById(sid);
	}

	public Student detail(Student s) {
		return sr.save(s);
	}

    public void deleteStudentById(Integer id) {
        sr.deleteById(id);
    }
}
