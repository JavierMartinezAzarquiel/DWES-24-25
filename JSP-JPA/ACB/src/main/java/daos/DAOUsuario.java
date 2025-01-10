package daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Equipo;
import model.Usuario;

public class DAOUsuario extends BaseJPADao{
	
	//método para insertar un usuario nuevo
	public static void insertarUsuario(Usuario u) {
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
		em.close();
	}
	
	//obtener un usuario
	public static Usuario getUsuario(String email) {
		EntityManager em=getEntityManager();
		//le decimos al entity manager que use una query que hemos fabricado nosotros
		TypedQuery<Usuario> q=em.createNamedQuery("Usuario.findByEmail",Usuario.class);
		q.setParameter("email", email);
		Usuario u; 
		try {
			u = q.getSingleResult();//lanzamos la query
		} catch (NoResultException e) {
			//si no hay resultado
			u=null;
		} 
		em.close();
		return u;
	}

}
