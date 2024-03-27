package com.elearningsystem.controller;

import com.elearningsystem.service.IStudentService;
import com.elearningsystem.vm.student.StudentDTO;
import com.elearningsystem.vm.student.response.StudentUpdateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    // TODO: remove if not required - this defines all possible responses of the api
    //    @Operation(summary = "Find a student of a certain course")
    //    @ApiResponses(value = {
    //            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
    //            @ApiResponse(responseCode = "404", description = "Student not found"),
    //            @ApiResponse(responseCode = "500", description = "Internal server error")
    //    })
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentUpdateResponse> updateStudent(
            @PathVariable Integer studentId,
            @Valid @RequestBody StudentDTO student) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, student));
    }

}
