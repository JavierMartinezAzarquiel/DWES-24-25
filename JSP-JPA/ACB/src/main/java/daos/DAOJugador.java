package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Jugador;

public class DAOJugador extends BaseJPADao{
	
	public static void actualizarJugador(Jugador j) {
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		// persist() solo para insert
		// remove() para hacer un delete
		em.merge(j); //forma de hacer un update
		tx.commit();
		em.close();
	}
	
	public static Jugador getJugador(long idJugador) {
		EntityManager em=getEntityManager();
		Jugador j = em.find(Jugador.class, idJugador);
		em.close();
		return j;
	}
}
