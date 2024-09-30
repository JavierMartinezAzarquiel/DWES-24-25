package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.Conexion;

public class DaoError {

	public DaoError() {
		// TODO Auto-generated constructor stub
	}


	public String getMensajeUsuario(String mensajeErrorOracle) throws SQLException, Exception {
		Conexion conexion = new Conexion();
		String mensaje=null;
		ResultSet rs=null;
		PreparedStatement st=null;
		Connection con=null;
		int inicio = mensajeErrorOracle.indexOf("(") + 1;
		int fin = mensajeErrorOracle.indexOf(")");
		String restriccionViolada = mensajeErrorOracle.substring(inicio, fin);
		try {
			con = conexion.getConexion();
			String ordenSql="SELECT MENSAJE FROM ERROR WHERE RESTRICCION=?";
			st=con.prepareStatement(ordenSql);
			st.setString(1, restriccionViolada);
			rs = st.executeQuery();
			if (rs.next()) {
				mensaje=rs.getString("MENSAJE");
			}
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		}
		finally{
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return mensaje;
	}

}
