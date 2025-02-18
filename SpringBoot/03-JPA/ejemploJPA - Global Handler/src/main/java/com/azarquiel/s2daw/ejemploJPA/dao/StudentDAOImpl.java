package com.azarquiel.s2daw.ejemploJPA.dao;

import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository  //para que se pueda crear un Bean, similar a @Component
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        Student estudiante = entityManager.merge(student);
        return estudiante;
    }

    @Override
    public List<Student> find() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s", Student.class);

        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByFirstName(String theFirstName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE firstName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theFirstName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student theStudent) {
        return entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

}
