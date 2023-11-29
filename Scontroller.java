package com.surya.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Scontroller {
	 @Autowired
	  private Studentservice ss ;
@GetMapping("/student")
public List<Student> getAlldata(@RequestParam(value="place" ,required = false)List<String> places,
		@RequestParam(value="age" ,required = false)Integer age) {
    return ss.getall(places,age);
}
@PostMapping("/student")
public Student sdetaill(@RequestBody Student s) {
	return ss.sdetail(s);
}
@RequestMapping("/student/{id}")
public Optional<Student> getstudentbyid(@PathVariable("id") Integer sid) {
	return ss.getbyid(sid);
}@PutMapping("/student")
public Student update(@RequestBody Student stu) {
	return ss.detail(stu);
}@DeleteMapping("/student/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
    try {
        ss.deleteStudentById(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Error deleting student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}
