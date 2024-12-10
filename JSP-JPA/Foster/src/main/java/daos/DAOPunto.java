package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Punto;

public class DAOPunto extends BaseJPADao{
	
	public void insertaPunto(Punto punto) {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(punto);
		tx.commit();
		em.close();
	}
	
//	public void insertaPunto(Punto punto) throws SQLException{
//		Connection con = null;
//		Conexion conex = new Conexion();
//		con = conex.getConexion();
//		String ordenSQL;
//		ordenSQL = "insert into punto values(?,?,?)";
//		PreparedStatement st = con.prepareStatement(ordenSQL);
//		st.setInt(1, punto.getId());
//		st.setInt(2, punto.getIdproducto());
//		st.setInt(3, punto.getPuntos());
//		st.executeUpdate();
//		st.close();
//	}

}
