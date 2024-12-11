package daos;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import model.Ciudad;
import model.Ruta;

public class DAOCiudad extends BaseJPADao{
	
	public static List<Ciudad> getCiudades(){
		EntityManager em=getEntityManager();
		List<Ciudad> ciudades =em.createNamedQuery("Ciudad.findAll",Ciudad.class).getResultList();
		em.close();
		return ciudades;
	}
	
	public static List<Ciudad> getCiudadesConRutas(){
//		EntityManager em=getEntityManager();
//		List<Ciudad> ciudadesConRutas= em.createNamedQuery("Ciudad.conRutas",Ciudad.class).getResultList();
//		em.close();
		List<Ciudad> ciudadesConRutas = new ArrayList<Ciudad>();
		List<Ciudad> todas = getCiudades();
		for (Ciudad ciudad : todas) {
			if( ! ciudad.getRutas().isEmpty()) {
				ciudadesConRutas.add(ciudad);
			}
		}
		
		return ciudadesConRutas;
	}
	
	
	public static Ciudad getCiudad(long idciudad) {
		EntityManager em=getEntityManager();
		Ciudad c = em.find(Ciudad.class, idciudad);
		for (Ruta r: c.getRutas() ) {
			em.refresh(r);
		}
		return c;
	}

}
