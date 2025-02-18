package com.azarquiel.s2daw.ejemploJPA.service;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentDAO;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//anotación de Clase Servicio
@Service
public class ServicioStudentImpl implements ServicioStudent{

    private StudentDAO studentDAO;

    @Autowired
    public ServicioStudentImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> find() {
        return studentDAO.find();
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentDAO.findByFirstName(firstName);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    @Override
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    @Override
    public int deleteAll() {
        return studentDAO.deleteAll();
    }
}
