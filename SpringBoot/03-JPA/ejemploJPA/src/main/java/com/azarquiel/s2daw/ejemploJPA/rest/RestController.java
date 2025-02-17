package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentDAO;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
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
}











