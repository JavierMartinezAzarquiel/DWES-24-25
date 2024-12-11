package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Punto;

public class DAOPunto extends BaseJPADao{
	
	public static void insertPunto(Punto punto) {
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(punto);
		tx.commit();
		em.close();
	}
	
//	public void insertPunto(Punto punto) throws SQLException{
//		Connection con  = new Conexion().getConexion();
//		String ordenSQL;
//		ordenSQL = "INSERT INTO PUNTO VALUES(?,?,?)";
//		PreparedStatement st = con.prepareStatement(ordenSQL);
//		st.setInt(1, punto.getId());
//		st.setInt(2, punto.getRuta());
//		st.setInt(3, punto.getPuntos());
//		st.executeUpdate();
//		st.close();
//	}

}
