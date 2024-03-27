package com.elearningsystem.controller.advice;

import com.elearningsystem.common.exception.ELearningGeneralException;
import com.elearningsystem.common.exception.InvalidRequestException;
import com.elearningsystem.common.exception.ResourceNotFoundException;
import com.elearningsystem.utils.MessageUtils;
import com.elearningsystem.vm.common.BaseResponse;
import com.elearningsystem.vm.common.message.ResponseMessage;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionTranslator {


    @ExceptionHandler(ELearningGeneralException.class)
    public ResponseEntity<BaseResponse> handleAttendanceGeneralException(final ELearningGeneralException ex) {
        final BaseResponse response = new BaseResponse();

        final ResponseMessage error = MessageUtils.createErrorMessage(ex.getMessage());
        response.getMessages().add(error);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<BaseResponse> handleInvalidRequestException(final InvalidRequestException ex) {
        final BaseResponse response = new BaseResponse();

        final ResponseMessage error = MessageUtils.createErrorMessage(ex.getMessage());
        response.getMessages().add(error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse> handleResourceNotFoundException(final ResourceNotFoundException ex) {
        final BaseResponse response = new BaseResponse();

        final ResponseMessage error = MessageUtils.createErrorMessage(ex.getMessage());
        response.getMessages().add(error);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponse> handleRequestParameterConstraintViolationException(final ConstraintViolationException ex) {
        final BaseResponse response = new BaseResponse();

        final ResponseMessage error = MessageUtils.createErrorMessage(ex.getMessage());
        response.getMessages().add(error);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleMethodArgNotValid(final MethodArgumentNotValidException ex) {
        final BaseResponse response = new BaseResponse();

        final List<ResponseMessage> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " :: " + fieldError.getDefaultMessage())
                .map(MessageUtils::createErrorMessage)
                .toList();
        response.getMessages().addAll(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleByDefault(final Exception ex) {
        log.error("An unexpected ERROR occurred with exception: {} ", ex.getMessage(), ex);

        final BaseResponse response = new BaseResponse();
        final ResponseMessage error = MessageUtils
                .createErrorMessage("An unexpected error occurred, please try again.");
        response.getMessages().add(error);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
