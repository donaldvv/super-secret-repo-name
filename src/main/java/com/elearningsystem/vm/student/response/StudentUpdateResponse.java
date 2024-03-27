package com.elearningsystem.vm.student.response;

import com.elearningsystem.vm.common.BaseResponse;
import com.elearningsystem.vm.student.StudentDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentUpdateResponse extends BaseResponse {

    private StudentDTO student;
}
