package com.student.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.info.model.Student;
import com.student.info.service.ServiceImpl;
import com.student.info.service.StudentService;

@RestController
public class MainController {
	@Autowired
	private ServiceImpl serviceImpl;

	@PostMapping("/save")
	public String saveStudent(@RequestBody Student std) {

		serviceImpl.saveStudent(std);
		return "student information save successfully";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable("id") int StId) {
		serviceImpl.deleteStudent(StId);
		return "record deleted successfully";
	}

	@GetMapping("/getByAge/{age1}")
	public Student getByAge(@PathVariable("age1") String age) {
		Student std = serviceImpl.selectStudentByAge(age);
		return std;
	}

	@PutMapping("/update/{id1}")
	public String updateStudent(@PathVariable("id1") int StId,@RequestBody Student std) {
		serviceImpl.updateStudent(std, StId);
		return "record is updated successfully";
	}
}
