package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BaseJPADao {
	/**
	 * Default no-arg constructor
	 */
	public BaseJPADao() {
	}
	
	/**
	 * Returns JPA EntityManager reference.
	 * @return 
	 */
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = PersistenceManagerSingleton.getInstance().getEntityManagerFactory();
		return emf.createEntityManager();
	}	
}