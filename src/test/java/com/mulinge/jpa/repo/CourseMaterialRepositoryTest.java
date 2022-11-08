package com.mulinge.jpa.repo;

import com.mulinge.jpa.models.Course;
import com.mulinge.jpa.models.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired CourseMaterialRepository courseMaterialRepository;

    @Test()
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}