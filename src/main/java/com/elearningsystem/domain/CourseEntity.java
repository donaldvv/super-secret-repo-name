package com.elearningsystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CourseEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private Integer courseID;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String Description;

    @Column(name = "Content",nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private SubjectEntity subject;
}
