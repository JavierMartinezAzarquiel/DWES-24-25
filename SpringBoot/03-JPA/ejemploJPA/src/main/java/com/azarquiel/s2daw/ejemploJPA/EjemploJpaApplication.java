package com.azarquiel.s2daw.ejemploJPA;

import com.azarquiel.s2daw.ejemploJPA.dao.StudentDAO;
import com.azarquiel.s2daw.ejemploJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EjemploJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//aquí vamos a ir probando los métodos del DAO
			//crearStudent(studentDAO);

			//probarListaEstudiantes(studentDAO);

			 //queryForStudentsByFirstName(studentDAO);

			 //updateStudent(studentDAO);

			 //deleteStudent(studentDAO);

			 //deleteAllStudents(studentDAO);
		};
	}

	public void crearStudent(StudentDAO studentDAO) {
		Student estudiante = new Student("Javier","Martinez","profesor.jjaviermc@ies-azarquiel.es");
		studentDAO.saveStudent(estudiante);
		System.out.println("Creado student con id: " + estudiante.getId());
	}

	public void probarListaEstudiantes(StudentDAO studentDAO) {
		List<Student> lista = studentDAO.find();
//		for (Student student : lista) {
//			System.out.println(student);
//		}
		lista.forEach(Student -> System.out.println(Student));
	}
	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.deleteById(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.updateStudent(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByFirstName("Javier");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}



}
