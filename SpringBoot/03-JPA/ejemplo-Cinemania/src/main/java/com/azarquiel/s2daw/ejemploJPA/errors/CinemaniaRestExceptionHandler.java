package com.azarquiel.s2daw.ejemploJPA.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CinemaniaRestExceptionHandler {

    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<CinemaniaErrorResponse> handleException(PeliculaNotFoundException exc) {

        CinemaniaErrorResponse error = new CinemaniaErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<CinemaniaErrorResponse> handleException(Exception exc) {

        // create a StudentErrorResponse
        CinemaniaErrorResponse error = new CinemaniaErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
