package daos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Municipio;
import model.Playa;
import model.PuntoView;


public class DAOPlaya extends BaseJPADao{

	public static Playa getPlaya(long id) {
		EntityManager em=getEntityManager();
		Playa p = em.find(Playa.class, id);
		em.close();
		return p;
	}


	public static List<PuntoView> getPuntos(long id) {
		EntityManager em=getEntityManager();
		Query q=em.createQuery("select p.puntos, count(p.puntos) from Punto p where p.playaBean.id="+id+" group by p.puntos order by p.puntos");

		List<Object[]> resultList = q.getResultList();
		List<PuntoView> puntuaciones = new ArrayList<>();
		for (Object[] row : resultList) {
			puntuaciones.add(new PuntoView((Integer) row[0], (Long)row[1]));
		}
		em.close();
		return puntuaciones;
	}
}
