package com.azarquiel.s2daw.ejemploJPA.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    //manejador de excepciones
//    @ExceptionHandler
//    public String exceptionHandler(StudentNotFoundException ex) {
//        return ex.getMessage();
//    }


    @ExceptionHandler
    public ResponseEntity<RespuestaEstudentException> handleException(StudentNotFoundException exc) {

        RespuestaEstudentException error = new RespuestaEstudentException();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RespuestaEstudentException> handleException(Exception exc) {

        RespuestaEstudentException error = new RespuestaEstudentException();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
