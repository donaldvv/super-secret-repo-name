package com.elearningsystem.service.mapper;

import com.elearningsystem.domain.StudentEntity;
import com.elearningsystem.vm.student.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentMapper {

    public StudentEntity toStudentEntity(final StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        final StudentEntity student = new StudentEntity();
        student.setFname(studentDTO.getFirstName());
        student.setLname(studentDTO.getLastName());
        student.setEmailID(studentDTO.getEmail());
        // TODO:

        return student;
    }

    public StudentDTO toStudentDTO(final StudentEntity student) {
        if (student == null) {
            return null;
        }
        final StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFname());
        studentDTO.setLastName(student.getLname());
        studentDTO.setEmail(student.getEmailID());
        // TODO:
        return studentDTO;
    }

    public List<StudentDTO> toStudentDTOs(final List<StudentEntity> students) {
        return Optional.ofNullable(students)
                .orElseGet(List::of)
                .stream()
                .filter(Objects::nonNull)
                .map(this::toStudentDTO)
                .toList();
    }

    public void mapStudentUpdate(final StudentEntity existingStudent, final StudentDTO studentUpdateData) {
        existingStudent.setFname(studentUpdateData.getFirstName());
        existingStudent.setLname(studentUpdateData.getLastName());
        existingStudent.setEmailID(studentUpdateData.getEmail());
        // TODO: add others
    }
}
