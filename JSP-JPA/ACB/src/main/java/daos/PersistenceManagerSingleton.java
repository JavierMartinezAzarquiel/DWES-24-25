package daos;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceManagerSingleton {
	 
	  public static final boolean DEBUG = true;
	  private static final String UNIDAD_PERSISTENCIA = "ACBPU";
	  
	  private static  PersistenceManagerSingleton instance = null;
	  
	  private EntityManagerFactory emf;
	  
	  public static PersistenceManagerSingleton getInstance() {
		
		  if (instance==null)
			  instance=new PersistenceManagerSingleton();
	    
	    return instance;
	  }
	  
	  private PersistenceManagerSingleton() {
	  }
	 
	  public EntityManagerFactory getEntityManagerFactory() {
	    
	    if (emf == null) {
		   emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
		      if (DEBUG) {
			      Logger logger=Logger.getLogger(PersistenceManagerSingleton.class.getName());
		          logger.log(Level.INFO," *** EntityManagerFactory creado *** ");
		      }
	    }
	    return emf;
	  }
	  
	  public void closeEntityManagerFactory() {
	    
	    if (emf != null) {
	      emf.close();
	      emf = null;
	      if (DEBUG) {
		      Logger logger=Logger.getLogger(PersistenceManagerSingleton.class.getName());
	          logger.log(Level.INFO," *** EntityManagerFactory cerrado *** ");
	      }
	    }
	    else {
	    	System.out.println("Entity Manager Factory es nulo");
	    }
	  }
	}

