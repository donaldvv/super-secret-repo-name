package com.elearningsystem.service;

import com.elearningsystem.vm.student.StudentDTO;
import com.elearningsystem.vm.student.response.StudentUpdateResponse;

public interface IStudentService {

    StudentUpdateResponse updateStudent(Integer studentId, StudentDTO student);
}
