package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Categoria;
import model.Producto;

public class Prueba {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FosterPU"); //ojo, con la Unidad de Persistencia
		
		EntityManager em = emf.createEntityManager();

		
		Categoria postres =  em.find(Categoria.class, 35L);
		
		System.out.println("La categoria obtenida es: " + postres.getNombre());
		
		System.out.println("Productos de esta categoría:");
		for (Producto p : postres.getProductos()) {
			System.out.println(p.getTitulo());
		}
		
		em.close();
		emf.close();
	}

}
