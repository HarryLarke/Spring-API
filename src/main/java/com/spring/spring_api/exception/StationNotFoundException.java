package com.spring.spring_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StationNotFoundException extends RuntimeException {
    
    public StationNotFoundException(String message){
        super(message);
    }

    public StationNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
