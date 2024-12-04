package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Libro;


public class PruebaLibro {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPAPU"); //ojo, con la Unidad de Persistencia
		
		EntityManager em = emf.createEntityManager();
		
		Libro libro = new Libro();
		libro.setTitle("The Hitchhiker's Guide to the Galaxy");
		libro.setPrice(12.5F);
		libro.setDescription("Science fiction comedy book");
		libro.setIsbn("1-84023-742-2");
		libro.setNbofpage(354);
		libro.setIllustrations(false);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(libro); //persistir un objeto, hacer un insert, update, delete
		tx.commit();
		
		Libro librocreado=em.find(Libro.class, 1L);
		System.out.println("Titulo del libro con id=1:"+librocreado.getDescription());
		em.close();
		emf.close();


	}

}
