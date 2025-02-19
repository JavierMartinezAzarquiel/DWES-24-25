package com.azarquiel.s2daw.ejemploJPA.service;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentRepository;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//anotación de Clase Servicio
@Service
public class ServicioStudentImpl implements ServicioStudent{

    private StudentRepository studentRepository;

    @Autowired
    public ServicioStudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> find() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> resultado = studentRepository.findById(id);

        if(resultado.isPresent()) {
            return resultado.get();
        }else{
            return null;
        }
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {

        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {

        studentRepository.deleteAll();;
    }

    @Override
    public List<Student> findEstudiantesConEmail() {
        return studentRepository.findEstudiantesConEmailPuntoEs();
    }
}
