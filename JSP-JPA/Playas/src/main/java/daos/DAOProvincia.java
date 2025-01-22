package daos;

import jakarta.persistence.EntityManager;
import model.Provincia;


public class DAOProvincia extends BaseJPADao{
	
	
	public static Provincia getProvincia(long id) {
		EntityManager em=getEntityManager();
		Provincia p = em.find(Provincia.class, id);
		em.close();
		return p;
	}
}
