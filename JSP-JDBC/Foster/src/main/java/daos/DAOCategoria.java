package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Categoria;

public class DAOCategoria {
	public ArrayList<Categoria> getAllCategorias() throws SQLException{
		ResultSet rs;
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		Connection con = null;
		Conexion conex = new Conexion();
		con = conex.getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * from categoria";
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("id"));
			categoria.setNombre(rs.getString("nombre"));
			categoria.setDescripcion(rs.getString("descripcion"));
			categoria.setGuarnicion(rs.getString("guarnicion"));
			lista.add(categoria);
		}
		rs.close();
		st.close();

		return lista;
	}


}
