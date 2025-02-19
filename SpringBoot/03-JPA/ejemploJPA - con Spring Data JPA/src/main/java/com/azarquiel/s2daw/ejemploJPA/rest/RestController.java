package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import com.azarquiel.s2daw.ejemploJPA.excepciones.StudentNotFoundException;
import com.azarquiel.s2daw.ejemploJPA.service.ServicioStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private ServicioStudent servicioStudent;

    @Autowired
    public RestController(ServicioStudent  servicioStudent) {
        this.servicioStudent = servicioStudent;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return servicioStudent.find();
    }

    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable int id) {

        return servicioStudent.findById(id);
    }

    //Preparar la respuesta para la petición POST -> hacer un insert con los datos que vengan en el body
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
       Student estudiante = servicioStudent.saveStudent(student);
       return estudiante;
    }

    //Acutalización de un estudiante usando metodo PUT
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
       Student estudiante = servicioStudent.updateStudent(student);

       return estudiante;
    }

    //Borrado de un estudiante usando DELETE
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        //busco el estudiante para comprobar que existe
        Student estudiante = servicioStudent.findById(id);

        //comprobamos
        if(estudiante == null) {
            //lanzar una excepcion
            throw new StudentNotFoundException("Student not found with id " + id);
        }

        servicioStudent.deleteById(id);
    }

    @GetMapping("/com")
    public List<Student> getComStudents() {
        return servicioStudent.findEstudiantesConEmail();
    }

}











