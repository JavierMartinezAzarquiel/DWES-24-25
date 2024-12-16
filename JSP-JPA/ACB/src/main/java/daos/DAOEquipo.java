package daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import model.Equipo;

public class DAOEquipo extends BaseJPADao{
	
	public static List<Equipo> getEquipos(){
		EntityManager em=getEntityManager();
		List<Equipo> equipos =em.createNamedQuery("Equipo.findAll",Equipo.class).getResultList();
		em.close();
		return equipos;
	}
	
		
	public static Equipo getEquipo(long idEquipo) {
		EntityManager em=getEntityManager();
		Equipo e = em.find(Equipo.class, idEquipo);
		em.close();
		return e;
	}

}
