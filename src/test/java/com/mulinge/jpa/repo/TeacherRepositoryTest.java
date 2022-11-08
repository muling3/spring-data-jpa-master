package com.mulinge.jpa.repo;

import com.mulinge.jpa.models.Course;
import com.mulinge.jpa.models.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired TeacherRepository teacherRepository;

    @Test
    public void createTeacher(){
        Course course = Course.builder()
                .title("Java Algorithms")
                .credit(5)
                .build();

//        Teacher teacher = Teacher.builder()
//                .firstName("Mgalla")
//                .lastName("Mvurya")
//                .courseList(List.of(course))
//                .build();
    }

}