package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Marca;

public class DAOMarca {
	
	public ArrayList<Marca> getMarcas() throws SQLException{
		ResultSet rs,p;
		ArrayList<Marca> lista = new ArrayList<Marca>();
		Connection con  = new Conexion().getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql;
		ordenSql = "SELECT * FROM MARCA";

		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Marca m = new Marca();
			m.setId(rs.getInt("ID"));
			m.setNombre(rs.getString("NOMBRE"));
			
			lista.add(m);
		}
		rs.close();
		st.close();

		return lista;
	}

}
