package com.mulinge.jpa.repo;

import com.mulinge.jpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE student SET first_name = ?1 WHERE email_address = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmail(String firstName, String email);
}
