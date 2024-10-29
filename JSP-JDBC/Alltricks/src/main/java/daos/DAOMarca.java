package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Marca;

public class DAOMarca {
	public ArrayList<Marca> getAllMarcas() throws SQLException{
		ResultSet rs;
		ArrayList<Marca> lista = new ArrayList<Marca>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * from marca";
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Marca marca = new Marca();
			marca.setId(rs.getInt("id"));
			marca.setNombre(rs.getString("nombre"));
			lista.add(marca);
		}
		rs.close();
		st.close();

		return lista;
	}


}
