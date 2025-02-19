package com.azarquiel.s2daw.ejemploJPA.dao;

import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="estudiantes")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Ya estarían todo los métodos de un DAO clásico

    List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.email like '%.es'")
    List<Student> findEstudiantesConEmailPuntoEs();
}
