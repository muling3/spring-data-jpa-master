package com.mulinge.jpa.models;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        uniqueConstraints = @UniqueConstraint(name = "unique_email_address", columnNames = "email_address")
)
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

}
