package com.mulinge.jpa.repo;

import com.mulinge.jpa.models.Course;
import com.mulinge.jpa.models.Student;
import com.mulinge.jpa.models.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courseList = courseRepository.findAll();

        System.out.println(courseList);
    }

    @Test
    public void saveCourse(){
        Teacher teacher = Teacher.builder()
                .firstName("Dennis")
                .lastName("Mwanza")
                .build();

        Course course = Course.builder()
                .title("UML")
                .teacher(teacher)
                .credit(8)
                .build();

        Course c = courseRepository.save(course);

        System.out.println(c);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Liskov")
                .lastName("Substitute")
                .build();

        Student student = Student.builder()
                .firstName("Roy")
                .lastName("Fielding")
                .emailId("roy.field@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .teacher(teacher)
                .students(List.of(student))
                .credit(4)
                .build();

        Course c = courseRepository.save(course);

        System.out.println(c);
    }

}