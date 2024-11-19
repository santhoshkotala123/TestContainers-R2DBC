package com.example.TestContainers_demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.example.TestContainers_demo.repositroy.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;
import reactor.core.publisher.Flux;

import com.example.TestContainers_demo.entities.Student;

@SpringBootTest
@Profile("test")
class TestContainersDemoApplicationTests {

    private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testcontainer")
            .withUsername("postgres")
            .withPassword("test");

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        if (!postgresContainer.isRunning()) {
            postgresContainer.start();
        }

        Student student1 = new Student();
        student1.setId(1L);
        student1.setName("Santhosh");

        Student student2 = new Student();
        student2.setId(2L);
        student2.setName("Santhosh");

        studentRepository.save(student1).block();
        studentRepository.save(student2).block();
    }

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setId(3L);
        student.setName("Santhosh");

        Student savedStudent = studentRepository.save(student).block();

        assertNotNull(savedStudent);
        assertTrue(savedStudent.getId() > 0);
    }

    @Test
    void testGetAllStudents() {
        Flux<Student> students = studentRepository.findAll();

        List<Student> studentList = students.collectList().block();
        assertTrue(studentList.size() > 0);
    }
}
