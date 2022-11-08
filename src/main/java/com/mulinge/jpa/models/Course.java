package com.mulinge.jpa.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_id_sequence", sequenceName = "course_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_sequence")
    private Long courseId;
    private String title;
    private int credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses_tbl",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;
}
