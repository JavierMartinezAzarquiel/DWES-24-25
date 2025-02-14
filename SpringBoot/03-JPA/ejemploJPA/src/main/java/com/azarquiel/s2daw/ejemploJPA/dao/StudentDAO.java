package com.azarquiel.s2daw.ejemploJPA.dao;

import com.azarquiel.s2daw.ejemploJPA.entity.Student;

import java.util.List;

public interface StudentDAO {
    //Listado de los métodos que tiene el DAO
    void saveStudent(Student student);
    List<Student> find();
    Student findById(int id);
    List<Student> findByFirstName(String firstName);
    void updateStudent(Student student);
    void deleteById(int id);
    int deleteAll();

}
