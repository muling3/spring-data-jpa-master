package com.mulinge.jpa.repo;

import com.mulinge.jpa.models.Guardian;
import com.mulinge.jpa.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    void findAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    void saveStudent() {
        Guardian guardian = Guardian.builder()
                .name("Alex Ferguson")
                .email("alex.fergie@gmail.com")
                .mobile("094973572")
                .build();

        Student student = Student.builder()
                .firstName("George")
                .lastName("Boole")
                .emailId("george.boole@gmail.com")
                .guardian(guardian)
                .build();

        Student s = studentRepository.save(student);
        System.out.println(s);
    }


    @Test
    void findByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("George");
        System.out.println(studentList);
    }

    @Test
    void findByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Ge");
        System.out.println(studentList);
    }

    @Test
    void updateStudentFirstNameByEmail() {
        int s = studentRepository.updateStudentFirstNameByEmail("Georgina", "george.boole@gmail.com");
        System.out.println(s);
    }
}