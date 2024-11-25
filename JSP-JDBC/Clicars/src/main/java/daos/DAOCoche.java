package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Coche;

public class DAOCoche {
	
	public ArrayList<Coche> getCoches() throws SQLException{
		ResultSet rs;
		ArrayList<Coche> lista = new ArrayList<Coche>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM COCHE";
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Coche c = new Coche();
			c.setId(rs.getInt("id"));
			c.setMarca(rs.getInt("marca"));
			c.setFoto(rs.getString("foto"));
			c.setNombre(rs.getString("nombre"));
			c.setModelo(rs.getString("modelo"));
			c.setPrecio(rs.getInt("precio"));
			c.setPrecioantes(rs.getInt("precioantes"));
			c.setAnio(rs.getInt("anio"));
			c.setKm(rs.getInt("km"));
			c.setCv(rs.getInt("cv"));
			c.setFav(rs.getInt("fav"));
			c.setLikes(rs.getInt("likes"));
			
			lista.add(c);
		}
		rs.close();
		st.close();

		return lista;
	}
	
	public ArrayList<Coche> getCoches(int idmarca) throws SQLException{
		ResultSet rs;
		ArrayList<Coche> lista = new ArrayList<Coche>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM COCHE WHERE MARCA="+idmarca;
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Coche c = new Coche();
			c.setId(rs.getInt("id"));
			c.setMarca(rs.getInt("marca"));
			c.setFoto(rs.getString("foto"));
			c.setNombre(rs.getString("nombre"));
			c.setModelo(rs.getString("modelo"));
			c.setPrecio(rs.getInt("precio"));
			c.setPrecioantes(rs.getInt("precioantes"));
			c.setAnio(rs.getInt("anio"));
			c.setKm(rs.getInt("km"));
			c.setCv(rs.getInt("cv"));
			c.setFav(rs.getInt("fav"));
			c.setLikes(rs.getInt("likes"));
			
			lista.add(c);
		}
		rs.close();
		st.close();

		return lista;
	}
	
	public ArrayList<Coche> getCoches(int idmarca,String orden) throws SQLException{
		ResultSet rs;
		ArrayList<Coche> lista = new ArrayList<Coche>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		String marca = String.valueOf(idmarca);
		System.out.println("idmarca: " + idmarca);
		if(idmarca==0) marca ="%";
		ordenSql = "SELECT * FROM COCHE WHERE MARCA LIKE '"+marca+"' ORDER BY "+orden;
	   	rs = st.executeQuery(ordenSql);
		while (rs.next()) {
			Coche c = new Coche();
			c.setId(rs.getInt("id"));
			c.setMarca(rs.getInt("marca"));
			c.setFoto(rs.getString("foto"));
			c.setNombre(rs.getString("nombre"));
			c.setModelo(rs.getString("modelo"));
			c.setPrecio(rs.getInt("precio"));
			c.setPrecioantes(rs.getInt("precioantes"));
			c.setAnio(rs.getInt("anio"));
			c.setKm(rs.getInt("km"));
			c.setCv(rs.getInt("cv"));
			c.setFav(rs.getInt("fav"));
			c.setLikes(rs.getInt("likes"));
			
			lista.add(c);
		}
		rs.close();
		st.close();

		return lista;
	}
	
	public void addLike(int idcoche) throws SQLException {
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "UPDATE COCHE SET LIKES=(SELECT LIKES+1 FROM COCHE WHERE ID="+idcoche+") WHERE ID="+idcoche;
	   	st.executeUpdate(ordenSql);
		
		st.close();
	}
}
