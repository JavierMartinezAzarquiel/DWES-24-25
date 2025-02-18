package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentDAO;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import com.azarquiel.s2daw.ejemploJPA.excepciones.RespuestaEstudentException;
import com.azarquiel.s2daw.ejemploJPA.excepciones.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private StudentDAO studentDAO;

    @Autowired
    public RestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentDAO.find();
    }

    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable int id) {

        return studentDAO.findById(id);
    }

    //Preparar la respuesta para la petición POST -> hacer un insert con los datos que vengan en el body
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
       Student estudiante = studentDAO.saveStudent(student);
       return estudiante;
    }

    //Acutalización de un estudiante usando metodo PUT
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
       Student estudiante = studentDAO.updateStudent(student);

       return estudiante;
    }

    //Borrado de un estudiante usando DELETE
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        //busco el estudiante para comprobar que existe
        Student estudiante = studentDAO.findById(id);

        //comprobamos
        if(estudiante == null) {
            //lanzar una excepcion
            throw new StudentNotFoundException("Student not found with id " + id);
        }

        studentDAO.deleteById(id);
    }

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











