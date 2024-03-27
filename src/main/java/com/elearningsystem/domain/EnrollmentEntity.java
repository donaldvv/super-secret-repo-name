package com.elearningsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class EnrollmentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollmentID")
    private Integer enrollmentID;
    @Column(name = "enrollmentdate",nullable = false)
    private LocalDate enrollmentDate;
    @ManyToOne
    @JoinColumn(name = "stdId")
    private StudentEntity student;



}
