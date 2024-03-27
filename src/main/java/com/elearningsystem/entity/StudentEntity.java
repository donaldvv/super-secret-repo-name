package com.elearningsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class StudentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stdId;
    @Column(name = "fname",nullable = false)
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "emailid")
    private String EmailID;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String Gender;
    @Column(name = "registrationdate")
    private Date registrationDate;
    @Column(name = "lastlogin")
    private Date lastLogin;
}
