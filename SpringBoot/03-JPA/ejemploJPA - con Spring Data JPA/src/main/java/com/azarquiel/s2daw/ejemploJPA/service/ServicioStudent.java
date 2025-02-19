package com.azarquiel.s2daw.ejemploJPA.service;

import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import java.util.List;

public interface ServicioStudent {

    Student saveStudent(Student student);
    List<Student> find();
    Student findById(int id);
    List<Student> findByFirstName(String firstName);
    Student updateStudent(Student student);
    void deleteById(int id);
    void deleteAll();
    List<Student> findEstudiantesConEmail();
}
