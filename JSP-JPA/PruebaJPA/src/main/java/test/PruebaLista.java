package test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Book;

public class PruebaLista {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPAPU"); //ojo, con la Unidad de Persistencia
		
		EntityManager em = emf.createEntityManager();
		
		//vamos a usar una consulta donde obtengamos un List<Book>
		
//		List<Book> lista =  em.createQuery("SELECT b FROM Book b",Book.class).getResultList();
		
		List<Book> lista =  em.createNamedQuery("Book.findAll",Book.class).getResultList();
		
		for (Book book : lista) {
			System.out.println(book);
		}
		
		em.close();
		emf.close();

	}

}
