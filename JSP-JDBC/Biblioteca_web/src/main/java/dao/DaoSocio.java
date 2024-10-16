package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexiones.Conexion;
import entidades.Socio;
import util.Hash;

public class DaoSocio {

	public DaoSocio() {
	}

	public ArrayList<Socio> listadoSocios() throws SQLException, Exception {
		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM SOCIO ORDER BY NOMBRE";
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setIdsocio(rs.getLong("IDSOCIO"));
				miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				listasocios.add(miSocio);
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
		System.out.println("El listado de socios se devuelve");
		return listasocios;
	}

	/****************************************************************************************/
	public ArrayList<Socio> listadoSocios(String criteriobusqueda)
			throws SQLException, Exception {

		// Problemas con inyeccion SQL maligno.
		// Probar esto en cuadro busqueda: %' AND DIRECCION LIKE 'T
		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT * FROM SOCIO WHERE " + criteriobusqueda
					+ " ORDER BY NOMBRE";
			System.out.println("La orden lanzada es: " + ordenSQL);
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setIdsocio(rs.getLong("IDSOCIO"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				listasocios.add(miSocio);
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
		return listasocios;
	}

	/**************************************************************/
	public Socio findSocioById(long idsocio) throws SQLException, Exception {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		Socio socio = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT IDSOCIO,NOMBRE,DIRECCION FROM SOCIO WHERE idsocio=?";
			//String ordenSQL = "SELECT IDSOCIO,NOMBRE,DIRECCION FROM SOCIO WHERE idsocio="+idsocio;
			st = con.prepareStatement(ordenSQL);
			st.setLong(1, idsocio);
			rs = st.executeQuery();  // CUIDADO CON ESCRIBIR rs = st.executeQuery(ordenSQL)  ESTO FALLA Y NO DE ERROR
			                         // DE COMPILACION
			if (rs.next()) {
				socio = new Socio();
				socio.setIdsocio(rs.getLong("IDSOCIO"));
				socio.setNombre(rs.getString("NOMBRE"));
				socio.setDireccion(rs.getString("DIRECCION"));
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
		return socio;

}
/*****************************************************************/
	public Socio findSocioByEmail(String email) throws SQLException, Exception {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement st = null;
	Socio socio = null;
	try {
		Conexion miconex = new Conexion();
		con = miconex.getConexion();
		String ordenSQL = "SELECT IDSOCIO,NOMBRE,EMAIL,DIRECCION FROM SOCIO WHERE email=?";
		st = con.prepareStatement(ordenSQL);
		st.setString(1, email);
		rs = st.executeQuery();
		if (rs.next()) {
			socio = new Socio();
			socio.setIdsocio(rs.getLong("IDSOCIO"));
			socio.setNombre(rs.getString("NOMBRE"));
			socio.setEmail(rs.getString("EMAIL"));
			socio.setDireccion(rs.getString("DIRECCION"));
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
	return socio;

}

/***********************************************************************/
	public ArrayList<Socio> listadoSociosByNombre(String nombre)
			throws SQLException, Exception {

		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "SELECT * FROM SOCIO WHERE UPPER(NOMBRE) LIKE UPPER(?)";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, "%" + nombre + "%");
			rs = st.executeQuery(); // no se le pasa la orden al método executeQuery
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setIdsocio(rs.getLong("IDSOCIO"));
				miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				listasocios.add(miSocio);
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
		return listasocios;
	}

	/****************************************************************************************************/
	public List<Socio> listadoSocios(int pagina, int numregpag)
			throws SQLException, Exception {

		List<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
//			String ordenSql = "SELECT IDSOCIO,EMAIL,NOMBRE,DIRECCION "
//					+ "FROM( SELECT ROWNUM FILA ,IDSOCIO,EMAIL,NOMBRE,DIRECCION "
//					+ "FROM( SELECT IDSOCIO,EMAIL,NOMBRE,DIRECCION "
//					+ "FROM SOCIO "
//					+ "ORDER BY NOMBRE))"
//					+ "WHERE FILA >=? AND FILA<=?";
			String ordenSql = "SELECT IDSOCIO,EMAIL,NOMBRE,DIRECCION FROM SOCIO";
			System.out.println("La orden lanzada es: " + ordenSql);
			st = con.prepareStatement(ordenSql);
//			st.setInt(1, (pagina * numregpag) + 1);
//			st.setInt(2, (pagina * numregpag) + numregpag);
			rs = st.executeQuery();
			//Ahora tengo todas las tuplas de socio
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setIdsocio(rs.getLong("IDSOCIO"));
				miSocio.setEmail(rs.getString("EMAIL"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				miSocio.setDireccion(rs.getString("DIRECCION"));
				listasocios.add(miSocio);
			}
			//ya tengo la lista con todos los socio.
			//tengo que seleccionar solo los que incluyen en la página pedida
			List<Socio> listaParcial = new ArrayList<Socio>();
			listaParcial = listasocios.subList((pagina * numregpag), (((pagina * numregpag)+ numregpag <listasocios.size()) ? (pagina * numregpag) + numregpag : listasocios.size() ));
			
//			for (int i = (pagina * numregpag); i < (((pagina * numregpag)+ numregpag <listasocios.size()) ? (pagina * numregpag) + numregpag : listasocios.size() ) ; i++) {
//				listaParcial.add(listasocios.get(i));
//			}
			listasocios = listaParcial;
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
		return listasocios;
	}

	/****************************************************************************************************/
	public int getTotalRegistros() throws SQLException, Exception {
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		int numeroRegistros = 0;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			st = con.createStatement();
			String ordenSQL = "SELECT COUNT(*) NUMEROREGISTROS FROM SOCIO";
			rs = st.executeQuery(ordenSQL);
			rs.next();
			numeroRegistros = rs.getInt("NUMEROREGISTROS");
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
		return numeroRegistros;
	}

	/***************************************************************************************************/
	public int updateSocio(Socio s) throws SQLException, Exception {
		int socioactualizado = 0;
		Connection con = null;
		PreparedStatement sentencia = null;
		PreparedStatement ordenselect = null;
		ResultSet rs = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			String slcSQL = "SELECT 'x' from socio where idsocio=? for update wait 3";
			ordenselect = con.prepareStatement(slcSQL);
			ordenselect.setLong(1, s.getIdsocio());
			rs = ordenselect.executeQuery();
			String ordenSQL = "UPDATE SOCIO SET NOMBRE=?,DIRECCION=? WHERE IDSOCIO=?";
			sentencia = con.prepareStatement(ordenSQL);
			sentencia.setString(1, s.getNombre());
			sentencia.setString(2, s.getDireccion());
			sentencia.setLong(3, s.getIdsocio());
			socioactualizado = sentencia.executeUpdate();
			//Error frecuente socioactualizado=sentencia.executeUpdate(ordenSQL);
		    con.commit();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (sentencia != null)
				sentencia.close();
			if (ordenselect != null)
				ordenselect.close();
			if (con != null)
				con.close();
		}
		return socioactualizado;
	}

	/* ********************************************************************** */
	public Socio insertarSocio(Socio s) throws SQLException, Exception {
		Connection con = null;
		PreparedStatement st = null;
		String ordenSQL = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false); //Para poder posponer el commit de los cambios
			ordenSQL = "INSERT INTO USUARIOS VALUES(?,?)";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, s.getEmail());
			st.setString(2, Hash.getHash(s.getClave(), "MD5") );
			st.executeUpdate();
			st.close();
			ordenSQL = "INSERT INTO GRUPOS VALUES(?,?)";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, "sociosbiblioteca");
			st.setString(2, s.getEmail());
			st.executeUpdate();
			st.close();
			ordenSQL = "INSERT INTO SOCIO(IDSOCIO,EMAIL,NOMBRE,DIRECCION,VERSION) VALUES(S_SOCIO.NEXTVAL,?,?,?,?)";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, s.getEmail());
			st.setString(2, s.getNombre());
			st.setString(3, s.getDireccion());
			st.setInt(4, 1);
			st.executeUpdate();
			con.commit();
			st.close();
			con.close();
		} catch (SQLException se) {
			if (con!=null)
			  con.rollback();
			throw se;
		} catch (Exception e) {
			throw e;
		} finally {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return s;
	}
/***************************************************************************/
	public ArrayList<Socio> listadoSociosMorosos()
			throws SQLException, Exception {

		ArrayList<Socio> listasocios;
		listasocios = new ArrayList<Socio>();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSql ="SELECT  IDSOCIO,NOMBRE "+
                             "FROM SOCIO S "+
                             "WHERE IDSOCIO IN(SELECT IDSOCIO "+
                                               "FROM PRESTAMO "+
                                                "WHERE FECHALIMITEDEVOLUCION<SYSDATE) "+
                             "ORDER BY S.NOMBRE";
			System.out.println("La orden lanzada es: " + ordenSql);
			st = con.createStatement();
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Socio miSocio = new Socio();
				miSocio.setIdsocio(rs.getLong("IDSOCIO"));
				miSocio.setNombre(rs.getString("NOMBRE"));
				listasocios.add(miSocio);
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
		return listasocios;
		
	}

	
	
}