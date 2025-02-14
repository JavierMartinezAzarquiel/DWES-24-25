package com.azarquiel.s2daw.ejemploJPA.rest;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentDAO;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
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
}
