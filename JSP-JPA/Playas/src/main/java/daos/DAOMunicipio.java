package daos;

import jakarta.persistence.EntityManager;
import model.Municipio;


public class DAOMunicipio extends BaseJPADao{
	
	public static Municipio getMunicipio(long id) {
		EntityManager em=getEntityManager();
		Municipio m = em.find(Municipio.class, id);
		em.close();
		return m;
	}
}
