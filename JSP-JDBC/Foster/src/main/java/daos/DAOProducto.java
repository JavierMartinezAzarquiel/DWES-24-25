package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Producto;

public class DAOProducto {
	public ArrayList<Producto> getProductosByCategoria(int idcategoria) throws SQLException{
		ResultSet rs;
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		Conexion conex = new Conexion();
		con = conex.getConexion();
		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * from producto where categoriaid="+idcategoria;
		rs = st.executeQuery(ordenSql);

		while (rs.next()) {
			Producto producto = new Producto();
			producto.setId(rs.getInt("id"));
			producto.setTitulo(rs.getString("titulo"));
			producto.setImagen(rs.getString("imagen"));
			producto.setBody(rs.getString("body"));
			producto.setSumario(rs.getString("sumario"));
			producto.setFondo(rs.getString("fondo"));
			producto.setCategoriaid(rs.getInt("categoriaid"));
			lista.add(producto);
		}
		rs.close();
		st.close();

		return lista;
	}


}
