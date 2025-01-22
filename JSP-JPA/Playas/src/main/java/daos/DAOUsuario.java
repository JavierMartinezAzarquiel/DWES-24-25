package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class DAOUsuario extends BaseJPADao{
	
	public static Usuario getUsuario(String nick, String pass) {
		EntityManager em=getEntityManager();
		TypedQuery<Usuario> q =em.createNamedQuery("Usuario.findByNick",Usuario.class);
		q.setParameter("nick", nick);
		q.setParameter("pass", pass);
		Usuario u;
		try {
			u = q.getSingleResult();
		} catch (NoResultException e) {
			u = null;
		}
		em.close();
		return u;
	}
	
	public static void insertaUsuario(Usuario u) {

		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
		em.close();
	}

}
