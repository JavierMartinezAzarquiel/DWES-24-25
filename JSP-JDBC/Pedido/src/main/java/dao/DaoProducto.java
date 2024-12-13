package dao;

import conexiones.Conexion;
import entidades.Cliente;
import entidades.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProducto {
	public DaoProducto() {
	}
	public ArrayList<Producto> listadoProductos() throws SQLException,
			Exception {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT ID, NOMBRE, PRECIO_NORMAL, PRECIO_MINIMO FROM PRODUCTO ORDER BY NOMBRE";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Producto miProducto = new Producto();
				miProducto.setId(rs.getLong("ID"));
				miProducto.setNombre(rs.getString("NOMBRE"));
				miProducto.setPrecio_normal(rs.getBigDecimal("PRECIO_NORMAL"));
				miProducto.setPrecio_minimo(rs.getBigDecimal("PRECIO_MINIMO"));
				listaProductos.add(miProducto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return listaProductos;
	}
/* *******************************************************************************/
	public Producto buscaproductoporid(long id) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT * FROM PRODUCTO WHERE ID=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setLong(1, id);
			rs = sentencia.executeQuery();
			if (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getLong("ID"));
				producto.setNombre(rs.getString("NOMBRE"));
				producto.setPrecio_normal(rs.getBigDecimal("PRECIO_NORMAL"));
				producto.setPrecio_minimo(rs.getBigDecimal("PRECIO_MINIMO"));
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			rs.close();
			sentencia.close();
			con.close();
		}
		return producto;
	}	
	/**********************************************************************************************/
	public ArrayList<Producto> listadoProductos(String criteriobusqueda)
			throws SQLException, Exception {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM PRODUCTO WHERE "
					+ criteriobusqueda + " ORDER BY NOMBRE";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Producto miProducto = new Producto();
				miProducto.setId(rs.getLong("ID"));
				miProducto.setNombre(rs.getString("NOMBRE"));
				miProducto.setPrecio_normal(rs.getBigDecimal("PRECIO_NORMAL"));
				miProducto.setPrecio_minimo(rs.getBigDecimal("PRECIO_MINIMO"));
				listaProductos.add(miProducto);
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}

		return listaProductos;
	}
	
}
