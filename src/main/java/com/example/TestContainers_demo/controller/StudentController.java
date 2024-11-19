package com.example.TestContainers_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.example.TestContainers_demo.entities.Student;
import com.example.TestContainers_demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public Mono<Student> save(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/getAll")
	public Flux<Student> getAll() {
		return studentService.getAll();
	}
}
