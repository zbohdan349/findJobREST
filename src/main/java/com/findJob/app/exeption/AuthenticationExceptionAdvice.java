package com.findJob.app.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class AuthenticationExceptionAdvice {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleMaxSizeException(BadCredentialsException exc) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exc.getMessage());
    }
}
