package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import conexiones.Conexion;
import entidades.Pedido;

public class DaoPedido {
	public DaoPedido() {
	}

	/********************** LISTADO DE TODOS LOS PEDIDOS **************************/
	public ArrayList<Pedido> listadoPedidos() throws SQLException, Exception {
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM PEDIDO ORDER BY IDPEDIDO DESC";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Pedido miPedido = new Pedido();
				miPedido.setIdpedido(rs.getInt("IDPEDIDO"));
				miPedido.setIdcliente(rs.getInt("IDCLIENTE"));
				miPedido.setFecha(rs.getDate("FECHA"));
				miPedido.setDirecciondeenvio(rs.getString("DIRECCIONDEENVIO"));
				miPedido.setEstado(rs.getString("ESTADO"));
				miPedido.setCobrado(rs.getString("COBRADO"));
				listaPedidos.add(miPedido);
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
		return listaPedidos;
	}

	/**************************** LISTADO DE PEDIDOS QUE CUMPLEN UN CRITERIO DE BUSQUEDA ********************************/
	public ArrayList<Pedido> listadoPedidos(String criteriobusqueda)
			throws SQLException, Exception {
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		Connection con = null;
		Statement sentencia = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			sentencia = con.createStatement();
			String ordenSQL = "SELECT * FROM PEDIDO WHERE " + criteriobusqueda
					+ " ORDER BY IDPEDIDO DESC";
			System.out.println(ordenSQL);
			rs = sentencia.executeQuery(ordenSQL);
			while (rs.next()) {
				Pedido miPedido = new Pedido();
				miPedido.setIdpedido(rs.getInt("IDPEDIDO"));
				miPedido.setIdcliente(rs.getInt("IDCLIENTE"));
				miPedido.setFecha(rs.getDate("FECHA"));
				miPedido.setDirecciondeenvio(rs.getString("DIRECCIONDEENVIO"));
				miPedido.setEstado(rs.getString("ESTADO"));
				miPedido.setCobrado(rs.getString("COBRADO"));
				listaPedidos.add(miPedido);
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

		return listaPedidos;
	}

	/************************************************************************************************************************************************************/
	public Double getImportePedido(int numeropedido) throws SQLException,
			Exception {

		Double importe;
		Connection con = null;
		Statement sentencia = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			sentencia = con.createStatement();
			String ordenSQL = "select SUM(TOTAL_LINEADETALLE)TOTAL FROM DETALLEPEDIDO WHERE IDPEDIDO="
					+ numeropedido;
			System.out.println(ordenSQL);
			rs = sentencia.executeQuery(ordenSQL);
			rs.next();
			importe = rs.getDouble("TOTAL");
			rs.close();
			sentencia.close();
			con.close();
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
		return importe;
	}

	/***************************** ELIMINAR UN PEDIDO ******************************************************/
	public int borrarpedido(int numeropedido) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement sentencia = null;
		int pedidoeliminado = 0;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			borrarlineasdetalle(numeropedido);
			String ordenSQL = "delete from pedido where idpedido=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setInt(1, numeropedido);
			pedidoeliminado = sentencia.executeUpdate();
			sentencia.close();
			con.close();
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (sentencia != null)
				sentencia.close();
			if (con != null)
				con.close();
		}
		return pedidoeliminado;
	}

	/***************************** ELIMINAR LAS LINEAS DE DETALLE DE UN PEDIDO ******************************************************/
	public void borrarlineasdetalle(int numeropedido) throws SQLException,
			Exception {
		Connection con = null;
		PreparedStatement sentencia = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "delete from detallepedido where idpedido=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setInt(1, numeropedido);
			sentencia.executeUpdate();
			sentencia.close();
			con.close();
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (sentencia != null)
				sentencia.close();
			if (con != null)
				con.close();
		}
	}

	/*****************************************************************************************************************/
	public void insertaPedido(Pedido p) throws SQLException, Exception {
       long longfechapedido=p.getFecha().getTime();
       System.out.println("La fecha del pedido es: "+longfechapedido);
       Time fechapedido=new Time(longfechapedido);
       //System.out.println("Hora del pedido: "+horapedido);
		Connection con = null;
		PreparedStatement sentencia = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			String ordenSQL = "INSERT INTO PEDIDO(IDPEDIDO,IDCLIENTE,FECHA,DIRECCIONDEENVIO) values(?,?,?,?)";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setLong(1, p.getIdpedido());
			sentencia.setLong(2, p.getIdcliente());
			sentencia.setDate(3, p.getFecha());
			sentencia.setString(4, p.getDirecciondeenvio());
			sentencia.executeUpdate();
			sentencia.close();
			con.close();
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (sentencia != null)
				sentencia.close();
			if (con != null)
				con.close();
		}
	}
	/************************************************************************************/
	public void insertaPedido(Pedido p,Connection con) throws SQLException, Exception {
	      long longfechapedido=p.getFecha().getTime();
	       System.out.println("La fecha del pedido es: "+longfechapedido);
	       Time fechapedido=new Time(longfechapedido);
	       //System.out.println("Hora del pedido: "+horapedido);
			PreparedStatement sentencia = null;
			try {
				String ordenSQL = "INSERT INTO PEDIDO(IDPEDIDO,IDCLIENTE,FECHA,DIRECCIONDEENVIO) values(?,?,?,?)";
				sentencia = con.prepareStatement(ordenSQL);
				sentencia.setLong(1, p.getIdpedido());
				sentencia.setLong(2, p.getIdcliente());
				sentencia.setDate(3, p.getFecha());
				sentencia.setString(4, p.getDirecciondeenvio());
				sentencia.executeUpdate();
				sentencia.close();
				TimeUnit.SECONDS.sleep(2);
			} catch (SQLException se) {
				if (sentencia != null)
					sentencia.close();
				if (con != null) {
					con.rollback();
					con.close();
				}
				throw se;
			} catch (Exception e) {
				if (sentencia != null)
					sentencia.close();
				if (con != null) {
					con.rollback();
					con.close();
				}
				throw e;
			}

	}
	/*********************************************************/

}
