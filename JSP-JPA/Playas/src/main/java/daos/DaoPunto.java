
package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Punto;

public class DaoPunto extends BaseJPADao  {

	public static void insertaPunto(Punto p) {

		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
		em.close();
	}


}
