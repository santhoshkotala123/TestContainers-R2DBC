package com.example.TestContainers_demo.service;

import com.example.TestContainers_demo.repositroy.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.example.TestContainers_demo.entities.Student;

@Service
public class StudentService {

	public StudentRepository studentRepository;

	public Mono<Student> saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	public Flux<Student> getAll() {
		return studentRepository.findAll();
	}
}
