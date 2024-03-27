package com.elearningsystem.common.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(final String message) {
        super(message);
    }
}
