package com.elearningsystem.service;

import com.elearningsystem.common.exception.ResourceNotFoundException;
import com.elearningsystem.domain.StudentEntity;
import com.elearningsystem.repository.StudentRepository;
import com.elearningsystem.service.mapper.StudentMapper;
import com.elearningsystem.utils.MessageUtils;
import com.elearningsystem.vm.student.StudentDTO;
import com.elearningsystem.vm.student.response.StudentUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentUpdateResponse updateStudent(final Integer studentId, final StudentDTO studentUpdateData) {
        final StudentEntity existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    log.error("Unable to update student! No student found by the provided ID!");
                    return new ResourceNotFoundException("Student with the provided ID does not exist!");
                });

        studentMapper.mapStudentUpdate(existingStudent, studentUpdateData);

        final StudentEntity updatedStudent = studentRepository.save(existingStudent);
        final StudentDTO resultStudentDTO = studentMapper.toStudentDTO(updatedStudent);

        final StudentUpdateResponse response = new StudentUpdateResponse();
        response.setStudent(resultStudentDTO);
        // TODO: if you need it, otherwise you can even return the StudentDTO directly and exclude StudentUpdateResponse
        response.getMessages().add(MessageUtils.createSuccessMessage("Update was successful!"));
        return response;
    }

//    private void validateStudentExists(final Integer studentId) {
//        final boolean isExistingCourse = studentRepository.existsById(studentId);
//        if (!isExistingCourse) {
//            log.error("Unable to add/update student! No student found by the provided ID!");
//            throw new ResourceNotFoundException("Student with the provided ID does not exist!");
//        }
//    }
}
