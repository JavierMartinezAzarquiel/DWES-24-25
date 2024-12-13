package dao;

import conexiones.Conexion;

import entidades.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

public class DaoCliente {
    public DaoCliente() {
    }
    public ArrayList<Cliente> listadoClientes() throws SQLException,Exception{
    	ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
    	Connection con=null;
    	Statement st=null;
    	ResultSet rs=null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM CLIENTE ORDER BY NOMBRE";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Cliente miCliente = new Cliente();
				miCliente.setId(rs.getInt("ID"));
				miCliente.setNombre(rs.getString("NOMBRE"));
				miCliente.setTipo(rs.getString("TIPO"));
				miCliente.setLimiteCredito(rs.getDouble("LIMITECREDITO"));
				listaClientes.add(miCliente);
			}

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st!=null)
				st.close();
			if (con != null)
				con.close();
		}
        return listaClientes;
     }
     /****************************   LISTADO DE CLIENTES QUE CUMPLEN UN CRITERIO DE BUSQUEDA  ********************************/
	public ArrayList<Cliente> listadoClientes(String criteriobusqueda)
			throws SQLException, Exception {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		Connection con = null;
		Statement sentencia = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			sentencia = con.createStatement();
			String ordenSQL = "SELECT * FROM CLIENTE WHERE " + criteriobusqueda
					+ " ORDER BY NOMBRE";
			System.out.print("ordenSQL");
			rs = sentencia.executeQuery(ordenSQL);
			while (rs.next()) {
				Cliente miCliente = new Cliente();
				miCliente.setId(rs.getInt("ID"));
				miCliente.setNombre(rs.getString("NOMBRE"));
				miCliente.setTipo(rs.getString("TIPO"));
				miCliente.setLimiteCredito(rs.getDouble("LIMITECREDITO"));
				listaClientes.add(miCliente);
			}
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (sentencia != null)
				sentencia.close();
			if (con != null)
				con.close();
		}
		return listaClientes;
	}
/**********************************************************************/
	public Cliente buscaclienteporid(long id) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT ID,NOMBRE,TIPO,LIMITECREDITO FROM CLIENTE WHERE ID=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setLong(1, id);
			rs = sentencia.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("ID"));
				cliente.setNombre(rs.getString("NOMBRE"));
				cliente.setTipo(rs.getString("TIPO"));
				cliente.setLimiteCredito(rs.getDouble("LIMITECREDITO"));
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
		return cliente;
	}
}
