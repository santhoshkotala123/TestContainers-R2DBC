package com.example.TestContainers_demo.repositroy;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.TestContainers_demo.entities.Student;

public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {

}
