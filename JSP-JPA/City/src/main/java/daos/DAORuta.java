package daos;

import model.Ruta;

public class DAORuta extends BaseJPADao{
	
	public static Ruta getRuta(long idRuta) {
		return getEntityManager().find(Ruta.class, idRuta);
	}
	
//	public ArrayList<Ruta> getRutas(int ciudad) throws SQLException{
//		ResultSet rs,p;
//		ArrayList<Ruta> lista = new ArrayList<Ruta>();
//		Connection con  = new Conexion().getConexion();
//		Statement st,stp;
//		st = con.createStatement();
//		stp = con.createStatement();
//		String ordenSql;
//		ordenSql = "SELECT * FROM RUTA WHERE CIUDAD="+ciudad;
//
//		rs = st.executeQuery(ordenSql);
//
//		while (rs.next()) {
//			Ruta ruta = new Ruta();
//			ruta.setId(rs.getInt("ID"));
//			ruta.setCiudad(rs.getInt("CIUDAD"));
//			ruta.setNombre(rs.getString("NOMBRE"));
//			ruta.setImagen(rs.getString("IMAGEN"));
//			ruta.setDescripcion(rs.getString("DESCRIPCION"));
//			ruta.setLink(rs.getString("LINK"));
//			ordenSql = "SELECT AVG(PUNTOS) MEDIA FROM PUNTO WHERE RUTA="+rs.getInt("ID");
//			p = stp.executeQuery(ordenSql);
//			p.next();
//			ruta.setMedia(p.getInt("MEDIA"));
//			lista.add(ruta);
//		}
//		rs.close();
//		st.close();
//
//		return lista;
//	}

}