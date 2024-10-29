package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Bici;

public class DAOBici {
	
	public ArrayList<Bici> getBicis(int idmarca, String ordenar,int fav) throws SQLException{
		ResultSet rs;
		ArrayList<Bici> lista = new ArrayList<Bici>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String idmarcatxt = String.valueOf(idmarca);
		if (idmarca ==0) idmarcatxt="%";
		String favorit = String.valueOf(fav);
		if (fav==0) favorit="0,1";
		String ordenSql;
		ordenSql = "select b.id, b.foto, b.marca, m.nombre, b.descripcion, b.precio, b.fav "
	   					+ "from bici b, marca m "
	   					+ "where b.marca=m.id and fav in ("+favorit+") and "
	   					+ "marca like '"+idmarcatxt+"' order by "+ordenar;

		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Bici bici = new Bici();
			bici.setId(rs.getInt("id"));
			bici.setFoto(rs.getString("foto"));
			bici.setMarca(rs.getInt("marca"));
			bici.setNombremarca(rs.getString("nombre"));
			bici.setDescripcion(rs.getString("descripcion"));
			bici.setPrecio(rs.getFloat("precio"));
			bici.setFav(rs.getInt("fav"));
			
			lista.add(bici);
		}
		rs.close();
		st.close();

		return lista;
	}

	public int changeFav(int currentfav, int idbici) throws SQLException {
		Connection con  = new Conexion().getConexion();
		int actualiza= -1;
		int fav = (currentfav==0)?1:0;
		String ordenSQL = "update bici set fav=? where id=?";
		PreparedStatement st = con.prepareStatement(ordenSQL);
		st.setInt(1, fav);
		st.setInt(2, idbici);
		actualiza = st.executeUpdate();
		st.close();

		return actualiza;
	}


}
