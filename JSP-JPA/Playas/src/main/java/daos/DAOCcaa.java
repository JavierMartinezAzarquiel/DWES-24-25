package daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import model.Ccaa;

public class DAOCcaa extends BaseJPADao{
	
	public static List<Ccaa> getAllCcaa(){
		EntityManager em=getEntityManager();
		List<Ccaa> comunidades =em.createNamedQuery("Ccaa.findAll",Ccaa.class).getResultList();
		em.close();
		return comunidades;
	}
	
		
	public static Ccaa getCcaa(long id) {
		EntityManager em=getEntityManager();
		Ccaa comunidad = em.find(Ccaa.class, id);
		em.close();
		return comunidad;
	}

}
