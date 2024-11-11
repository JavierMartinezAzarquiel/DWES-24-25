package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Ciudad;

public class DAOCiudad {
	
	public ArrayList<Ciudad> getCiudades() throws SQLException{
		ResultSet rs;
		ArrayList<Ciudad> lista = new ArrayList<Ciudad>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM CIUDAD";
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(rs.getInt("id"));
			ciudad.setNombre(rs.getString("nombre"));
			ciudad.setImagen(rs.getString("imagen"));
			ciudad.setDescripcion(rs.getString("descripcion"));
			ciudad.setLink(rs.getString("link"));
			ciudad.setMapa(rs.getString("mapa"));
			
			lista.add(ciudad);
		}
		rs.close();
		st.close();

		return lista;
	}
	
	public ArrayList<Ciudad> getCiudadesConRutas() throws SQLException{
		ResultSet rs;
		ArrayList<Ciudad> lista = new ArrayList<Ciudad>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM CIUDAD WHERE ID IN (SELECT CIUDAD FROM RUTA)";
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(rs.getInt("id"));
			ciudad.setNombre(rs.getString("nombre"));
			ciudad.setImagen(rs.getString("imagen"));
			ciudad.setDescripcion(rs.getString("descripcion"));
			ciudad.setLink(rs.getString("link"));
			ciudad.setMapa(rs.getString("mapa"));
			
			lista.add(ciudad);
		}
		rs.close();
		st.close();

		return lista;
	}

	public Ciudad getCiudad(int idciudad) throws SQLException{
		ResultSet rs;
		Ciudad ciudad = null;
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM CIUDAD WHERE ID ="+idciudad;
	   	rs = st.executeQuery(ordenSql);
		if (rs.next()) {
			ciudad = new Ciudad();
			ciudad.setId(rs.getInt("id"));
			ciudad.setNombre(rs.getString("nombre"));
			ciudad.setImagen(rs.getString("imagen"));
			ciudad.setDescripcion(rs.getString("descripcion"));
			ciudad.setLink(rs.getString("link"));
			ciudad.setMapa(rs.getString("mapa"));
			
		}
		rs.close();
		st.close();

		return ciudad;
	}

}
