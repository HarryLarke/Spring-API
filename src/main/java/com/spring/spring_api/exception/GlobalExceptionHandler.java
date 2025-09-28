package com.spring.spring_api.exception;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<ApiError> handle(MemberNotFoundException e, HttpServletRequest req){
        ApiError apiError = new ApiError(
            req.getRequestURI(),
            e.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            ZonedDateTime.now(),
            List.of()
        );
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
