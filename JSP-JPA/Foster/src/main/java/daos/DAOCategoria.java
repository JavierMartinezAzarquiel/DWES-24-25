package daos;

import java.util.List;
import jakarta.persistence.EntityManager;
import model.Categoria;

public class DAOCategoria extends BaseJPADao{
	
	public List<Categoria> getAllCategorias(){
		EntityManager em = getEntityManager(); //obtener el Entity Manager
		//Obtener una lista con todas las categorías
		List<Categoria> listaCategorias = em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
		em.close();
		return listaCategorias;
	}
	
	
//	public ArrayList<Categoria> getAllCategorias() throws SQLException{
//		ResultSet rs;
//		ArrayList<Categoria> lista = new ArrayList<Categoria>();
//		Connection con = null;
//		Conexion conex = new Conexion();
//		con = conex.getConexion();
//		Statement st;
//		st = con.createStatement();
//		String ordenSql = "SELECT * from categoria";
//		rs = st.executeQuery(ordenSql);
//
//		while (rs.next()) {
//			Categoria categoria = new Categoria();
//			categoria.setId(rs.getInt("id"));
//			categoria.setNombre(rs.getString("nombre"));
//			categoria.setDescripcion(rs.getString("descripcion"));
//			categoria.setGuarnicion(rs.getString("guarnicion"));
//			lista.add(categoria);
//		}
//		rs.close();
//		st.close();
//
//		return lista;
//	}


}
