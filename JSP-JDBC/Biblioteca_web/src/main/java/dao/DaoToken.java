package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.Conexion;
import entidades.Socio;
import entidades.Token;

public class DaoToken {

	public DaoToken() {
		super();
	}

	public void addToken(Token t) throws Exception {
		Connection con =null;
		Conexion miconex = new Conexion();
		try {
			con = miconex.getConexion();
			PreparedStatement st = null;
			String sql = "INSERT INTO TOKEN(EMAIL,CLAVE,VALUE,TELEFONO,FECHA_INICIO) VALUES(?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, t.getEmail());
			st.setString(2, t.getClave());
			st.setString(3, t.getValue());
			st.setString(4, t.getTelefono());
			st.setTimestamp(5, t.getFecha());
			st.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}finally {
			if(con!=null) {
				con.close();
			}
		}
	}
	
	public Token findTokenByEmail(String email) throws Exception {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Token token = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT * FROM TOKEN WHERE email=?";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, email);
			rs = st.executeQuery();
			if (rs.next()) {
				token = new Token();
				token.setEmail(rs.getString("EMAIL"));
				token.setValue(rs.getString("VALUE"));
				token.setClave(rs.getString("CLAVE"));
				token.setFecha(rs.getTimestamp("FECHA_INICIO"));
				token.setTelefono(rs.getString("TELEFONO"));
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
		return token;
	}
}
