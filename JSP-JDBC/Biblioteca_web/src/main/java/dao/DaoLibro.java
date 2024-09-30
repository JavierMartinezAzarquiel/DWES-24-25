package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Libro;

public class DaoLibro {
	public DaoLibro() {

	}

	public void insertaLibro(Libro l, int numejemplares) throws SQLException, Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection con = null;
		int maxidejemplar = 0;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			String ordenSQL = "INSERT INTO LIBRO VALUES(?,?,?)";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, l.getIsbn());
			st.setString(2, l.getTitulo());
			st.setInt(3, l.getIdautor());
			st.execute();
			st.close();
			if (numejemplares > 0) {
				ordenSQL = "select max(idejemplar) maxidejemplar from ejemplar";
				st = con.prepareStatement(ordenSQL);
				rs = st.executeQuery();
				if (rs.next())
					maxidejemplar = rs.getInt("maxidejemplar");
				rs.close();
				st.close();
				ordenSQL = "insert into ejemplar(idejemplar,isbn,baja) values(?,?,?)";
				for (int i = 1; i <= numejemplares; i++) {
					st = con.prepareStatement(ordenSQL);
					st.setInt(1, maxidejemplar + i);
					st.setString(2, l.getIsbn());
					st.setString(3, "N");
					st.execute();
					st.close();
				}
				
			}
			con.commit();
		} catch (SQLException se) {
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
	}

	/******************************************************************/
//
//	public ArrayList<Libro> listadoLibros(String criteriobusqueda, String valorbusqueda)
//			throws SQLException, Exception {
//		ArrayList<Libro> listalibros;
//		listalibros = new ArrayList<Libro>();
//		ResultSet rs;
//		PreparedStatement st;
//		String titulo, isbn, autor = null;
//		if (criteriobusqueda.equals("autor")) {
//			titulo = "%";
//			isbn = "%";
//			autor = "%" + valorbusqueda + "%";
//		} else if (criteriobusqueda.equals("titulo")) {
//			autor = "%";
//			isbn = "%";
//			titulo = "%" + valorbusqueda + "%";
//		} else {
//			autor = "%";
//			titulo = "%";
//			isbn = valorbusqueda;
//		}
//		try {
//			Conexion miconex = new Conexion();
//			Connection con = miconex.getConexion();
//			String ordenSQL = "SELECT T.ISBN,TITULO,AUTOR.NOMBRE AUTOR, EJEMPLARESTOTALES, EJEMPLARESENPRESTAMO,(EJEMPLARESTOTALES-EJEMPLARESENPRESTAMO)EJEMPLARESDISPONIBLES"
//					+ " FROM LIBRO T,AUTOR," + "("
//					+ " SELECT A.ISBN,EJEMPLARES EJEMPLARESTOTALES,NVL(EJEMPLARESPRESTADOS,0)EJEMPLARESENPRESTAMO"
//					+ " FROM" + "(SELECT L.ISBN,COUNT(*)EJEMPLARES" + " FROM LIBRO L,EJEMPLAR E"
//					+ " WHERE L.ISBN=E.ISBN" + " AND E.BAJA='N'" + " GROUP BY L.ISBN)A,"
//					+ " (SELECT ISBN,COUNT(*) EJEMPLARESPRESTADOS" + " FROM PRESTAMO P,EJEMPLAR E"
//					+ " WHERE P.IDEJEMPLAR=E.IDEJEMPLAR" + " GROUP BY ISBN)B" + " WHERE A.ISBN=B.ISBN(+))A"
//					+ " WHERE T.ISBN=A.ISBN" + " AND T.IDAUTOR=AUTOR.IDAUTOR"
//					+ " AND TRANSLATE(UPPER(AUTOR.NOMBRE),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"
//					+ " AND TRANSLATE(UPPER(T.TITULO),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE  TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"
//					+ " AND T.ISBN LIKE ?" + " ORDER BY AUTOR,TITULO";
//			st = con.prepareStatement(ordenSQL);
//			st.setString(1, autor);
//			st.setString(2, titulo);
//			st.setString(3, isbn);
//			rs = st.executeQuery();
//			while (rs.next()) {
//				Libro libro = new Libro();
//				libro.setIsbn(rs.getString("ISBN"));
//				libro.setTitulo(rs.getString("TITULO"));
//				libro.setNombreAutor(rs.getString("AUTOR"));
//				libro.setEjemplaresTotales(rs.getInt("EJEMPLARESTOTALES"));
//				libro.setEjemplaresEnPrestamo(rs.getInt("EJEMPLARESENPRESTAMO"));
//				libro.setEjemplaresDisponibles(rs.getInt("EJEMPLARESDISPONIBLES"));
//				listalibros.add(libro);
//			}
//			rs.close();
//			st.close();
//			con.close();
//		} catch (SQLException se) {
//			throw se;
//		} catch (Exception e) {
//			throw e;
//		}
//		System.out.println(listalibros.size());
//		return listalibros;
//	}
/************************************************************************/

	public ArrayList<Libro> listadoLibros(String criteriobusqueda, String valorbusqueda)
			throws SQLException, Exception {
		ArrayList<Libro> listalibros;
		listalibros = new ArrayList<Libro>();
		ResultSet rs;
		PreparedStatement st;
		String titulo, isbn, autor = null;
		if (criteriobusqueda.equals("autor")) {
			titulo = "%";
			isbn = "%";
			autor = "%" + valorbusqueda + "%";
		} else if (criteriobusqueda.equals("titulo")) {
			autor = "%";
			isbn = "%";
			titulo = "%" + valorbusqueda + "%";
		} else {
			autor = "%";
			titulo = "%";
			isbn = valorbusqueda;
		}
		try {
			Conexion miconex = new Conexion();
			Connection con = miconex.getConexion();
			String ordenSQL ="SELECT L.ISBN,L.TITULO,A.NOMBRE AUTOR,EJEMPLARESTOTALES,EJEMPLARESENPRESTAMO, " + 
					"      (EJEMPLARESTOTALES-EJEMPLARESENPRESTAMO)EJEMPLARESDISPONIBLES " + 
					"FROM LIBRO L,AUTOR A, " + 
					"(" + 
					"SELECT A.ISBN,EJEMPLARESTOTALES,NVL(EJEMPLARESENPRESTAMO,0)EJEMPLARESENPRESTAMO " + 
					"FROM " + 
					"  ( " + 
					"    SELECT L.ISBN,COUNT(*)EJEMPLARESTOTALES " + 
					"    FROM LIBRO L,EJEMPLAR E " + 
					"    WHERE L.ISBN=E.ISBN " + 
					"    AND E.BAJA='N' " + 
					"    GROUP BY L.ISBN " + 
					"  )A LEFT JOIN " + 
					"    ( SELECT ISBN,COUNT(*) EJEMPLARESENPRESTAMO " + 
					"      FROM PRESTAMO P,EJEMPLAR E " + 
					"      WHERE P.IDEJEMPLAR=E.IDEJEMPLAR "  + 
					"      GROUP BY ISBN)B " + 
					"ON A.ISBN=B.ISBN)B " + 
					"WHERE L.ISBN=B.ISBN " + 
					"AND L.IDAUTOR=A.IDAUTOR " + 
					"AND TRANSLATE(UPPER(A.NOMBRE),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U') " + 
					"AND TRANSLATE(UPPER(L.TITULO),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE  TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U') " + 
					"AND L.ISBN LIKE ? " + 
					"ORDER BY AUTOR,TITULO ";
			st = con.prepareStatement(ordenSQL);
			st.setString(1, autor);
			st.setString(2, titulo);
			st.setString(3, isbn);
			rs = st.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("ISBN"));
				libro.setTitulo(rs.getString("TITULO"));
				libro.setNombreAutor(rs.getString("AUTOR"));
				libro.setEjemplaresTotales(rs.getInt("EJEMPLARESTOTALES"));
				libro.setEjemplaresEnPrestamo(rs.getInt("EJEMPLARESENPRESTAMO"));
				libro.setEjemplaresDisponibles(rs.getInt("EJEMPLARESDISPONIBLES"));
				listalibros.add(libro);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println(listalibros.size());
		return listalibros;
	}
	
	
	
	/***************************************************************/
	public ArrayList<Libro> listadoLibros(String titulo, String autor, String isbn) throws SQLException, Exception {
		ArrayList<Libro> listalibros;
		listalibros = new ArrayList<Libro>();
		ResultSet rs;
		PreparedStatement st;
		try {
			Conexion miconex = new Conexion();
			Connection con = miconex.getConexion();
			String ordenSQL = "SELECT T.ISBN,TITULO,AUTOR.NOMBRE AUTOR, EJEMPLARESTOTALES, EJEMPLARESENPRESTAMO,(EJEMPLARESTOTALES-EJEMPLARESENPRESTAMO)EJEMPLARESDISPONIBLES"
					+ " FROM LIBRO T,AUTOR," + "("
					+ " SELECT A.ISBN,EJEMPLARES EJEMPLARESTOTALES,NVL(EJEMPLARESPRESTADOS,0)EJEMPLARESENPRESTAMO"
					+ " FROM" + "(SELECT L.ISBN,COUNT(*)EJEMPLARES" + " FROM LIBRO L,EJEMPLAR E"
					+ " WHERE L.ISBN=E.ISBN" + " AND E.BAJA='N'" + " GROUP BY L.ISBN)A,"
					+ " (SELECT ISBN,COUNT(*) EJEMPLARESPRESTADOS" + " FROM PRESTAMO P,EJEMPLAR E"
					+ " WHERE P.IDEJEMPLAR=E.IDEJEMPLAR" + " GROUP BY ISBN)B" + " WHERE A.ISBN=B.ISBN(+))A"
					+ " WHERE T.ISBN=A.ISBN" + " AND T.IDAUTOR=AUTOR.IDAUTOR"
					+ " AND TRANSLATE(UPPER(AUTOR.NOMBRE),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"
					+ " AND TRANSLATE(UPPER(T.TITULO),'Á,É,Í,Ó,Ú','A,E,I,O,U') LIKE  TRANSLATE(UPPER(?),'Á,É,Í,Ó,Ú','A,E,I,O,U')"
					+ " AND T.ISBN LIKE ?" + " ORDER BY AUTOR,TITULO";

			System.out.println("El autor es: " + autor);
			System.out.println("El titulo es: " + titulo);
			st = con.prepareStatement(ordenSQL);
			st.setString(1, autor);
			st.setString(2, titulo);
			st.setString(3, isbn);
			rs = st.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIsbn(rs.getString("ISBN"));
				libro.setTitulo(rs.getString("TITULO"));
				libro.setNombreAutor(rs.getString("AUTOR"));
				libro.setEjemplaresTotales(rs.getInt("EJEMPLARESTOTALES"));
				libro.setEjemplaresEnPrestamo(rs.getInt("EJEMPLARESENPRESTAMO"));
				libro.setEjemplaresDisponibles(rs.getInt("EJEMPLARESDISPONIBLES"));
				listalibros.add(libro);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}
		System.out.println(listalibros.size());
		return listalibros;
	}
}
