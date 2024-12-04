package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Book;

public class Prueba {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPAPU"); //ojo, con la Unidad de Persistencia
		
		EntityManager em = emf.createEntityManager();
		
		Book book = new Book();
		book.setTitle("The Hitchhiker's Guide to the Galaxy");
		book.setPrice(12.5F);
		book.setDescription("Science fiction comedy book");
		book.setIsbn("1-84023-742-2");
		book.setNbofpage(354);
		book.setIllustrations(false);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book); //persistir un objeto, hacer un insert, update, delete
		tx.commit();
		
		Book librocreado=em.find(Book.class, 1L);
		System.out.println("Titulo del libro con id=1:"+librocreado.getDescription());
		em.close();
		emf.close();


	}

}
