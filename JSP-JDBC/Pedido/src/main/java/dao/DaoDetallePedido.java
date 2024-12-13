package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.DetallePedido;

public class DaoDetallePedido {
	public DaoDetallePedido() {
	}

	public ArrayList<DetallePedido> listadoDetallePedido(long numeropedido) throws SQLException, Exception {
		ArrayList<DetallePedido> listadetallepedido = new ArrayList<DetallePedido>();
		Connection con = null;
		PreparedStatement sentencia = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT IDPEDIDO,LINEADETALLE,NOMBRE DESCRIPCION,CANTIDAD,PRECIO_UNITARIO,TOTAL_LINEADETALLE"
					+ " FROM DETALLEPEDIDO DP,PRODUCTO P" + " WHERE DP.IDPRODUCTO=P.ID AND IDPEDIDO=?";
			System.out.println("Sentencia para el detalle: " + ordenSQL);
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setLong(1, numeropedido);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				DetallePedido miDetallepedido = new DetallePedido();
				miDetallepedido.setIdpedido(rs.getInt("IDPEDIDO"));
				miDetallepedido.setLineadetalle(rs.getInt("LINEADETALLE"));
				miDetallepedido.setDescripcion(rs.getString("DESCRIPCION"));
				miDetallepedido.setCantidad(rs.getInt("CANTIDAD"));
				miDetallepedido.setPrecio_unitario(rs.getBigDecimal("PRECIO_UNITARIO"));
				miDetallepedido.setTotal_lineadetalle(rs.getBigDecimal("TOTAL_LINEADETALLE"));
				listadetallepedido.add(miDetallepedido);
			}
			rs.close();
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
		return listadetallepedido;
	}

	/******************************************************************************************/
	public void insertaDetallePedido(DetallePedido dp) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			String ordenSQL = "INSERT INTO DETALLEPEDIDO VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(ordenSQL);
			ps.setLong(1, dp.getIdpedido());
			ps.setInt(2, dp.getLineadetalle());
			ps.setLong(3, dp.getIdproducto());
			ps.setInt(4, dp.getCantidad());
			ps.setBigDecimal(5, dp.getPrecio_unitario());
			ps.setBigDecimal(6, dp.getTotal_lineadetalle());
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}

	}

	/*************** FIN DEL METODO ************************************/
	public void insertaDetallePedido(DetallePedido dp, Connection con) throws SQLException, Exception {
		PreparedStatement ps = null;
		try {
			String ordenSQL = "INSERT INTO DETALLEPEDIDO VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(ordenSQL);
			ps.setLong(1, dp.getIdpedido());
			ps.setInt(2, dp.getLineadetalle());
			ps.setLong(3, dp.getIdproducto());
			ps.setInt(4, dp.getCantidad());
			ps.setBigDecimal(5, dp.getPrecio_unitario());
			ps.setBigDecimal(6, dp.getTotal_lineadetalle());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException se) {
			if (ps != null)
				ps.close();
			if (con != null) {
				con.rollback();
				con.close();
			}
			throw se;
		} catch (Exception e) {
			if (ps != null)
				ps.close();
			if (con != null) {
				con.rollback();
				con.close();
			}
			throw e;
		}

	}
}
