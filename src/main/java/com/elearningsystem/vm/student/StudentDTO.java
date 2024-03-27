package com.elearningsystem.vm.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {

    private Long id;

    // TODO: or get message from file
    @NotNull(message = "The first name can not be null")
    @NotBlank(message = "The first name can not be blank")
    private String firstName;
    private String lastName;

    @NotNull(message = "The email can not be null")
    @NotBlank(message = "The email can not be blank")
    @Email(message = "The email is not valid")
    private String email;

    // TODO: add others
}
