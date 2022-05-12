package com.jbk.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping(value = "/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student std = service.saveStudent(student);
		if (std != null) {
			return new ResponseEntity<>(std, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/getStudent/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable String studentId) {

		Student student = service.getStudentById(studentId);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}


	}
	
	@GetMapping(value = "/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() {
		
		return null;

}
}
