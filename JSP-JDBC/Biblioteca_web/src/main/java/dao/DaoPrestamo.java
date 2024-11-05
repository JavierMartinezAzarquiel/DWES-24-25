package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Prestamo;
import excepciones.PrestamoException;

public class DaoPrestamo {

	public DaoPrestamo() {
	}
	/********************************************************************************/
	public void insertaPrestamo(Prestamo p)throws PrestamoException,SQLException,Exception{
		String ordenSQL;
		Connection con=null;
		PreparedStatement sentencia=null;
		DaoEjemplar daoEjemplar=new DaoEjemplar();
		DaoSocio daoSocio = new DaoSocio();
		// Comprobación de que el ejemplar existe en la base de datos
		if(daoEjemplar.findEjemplarById(p.getIdejemplar())==null)
			throw new PrestamoException("Ejemplar no existente o dado de baja"); 
		// Comprobación de que el ejemplar no está ya prestado
		Prestamo prestamo = this.findPrestamoById(p.getIdejemplar());    
		if(prestamo!=null)
			throw new PrestamoException("Préstamo duplicado. El ejemplar indicado está en préstamo");
		// Comprobar que el codigo de socio es válido(El socio existe)
		if (daoSocio.findSocioById(p.getIdsocio()) == null) {
			throw new PrestamoException("El código de socio no existe");
		}
		try{
			Conexion miconex=new Conexion();
			con=miconex.getConexion();
			//Comprobación de que el socio no tiene préstamos pasados de fecha
			ArrayList<Prestamo> lista = this.listadoPrestamosFueraPlazo(p.getIdsocio());
			if(!lista.isEmpty()) {
				throw new PrestamoException("El socio tiene prestamos fuera de plazo");
			}

			//Comprobación que el socio no está en la lista de sancionados, y si lo estuviese
			// hay que comprobar que la fecha de sanción no sigue vigente
			ordenSQL="SELECT to_char(LIMITEPENALIZACION, 'dd-mm-yyyy') FECHALIMITEPENALIZACION "
					+ "FROM SOCIOPENALIZADO "
					+ "WHERE IDSOCIO = ? AND LIMITEPENALIZACION > SYSDATE";
			sentencia=con.prepareStatement(ordenSQL);
			sentencia.setLong(1, p.getIdsocio());
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				throw new PrestamoException("El socio está penalizado hasta el día: "+rs.getString("FECHALIMITEPENALIZACION"));
			}

			//Comprobación de que el socio no tenga ya un prestamos de otro ejemplar del mismo libro
			ordenSQL="SELECT COUNT(P.IDEJEMPLAR)NUMEROEJEMPLARES "
					+ "FROM PRESTAMO P,EJEMPLAR E, LIBRO L "
					+ "WHERE P.IDEJEMPLAR=E.IDEJEMPLAR AND E.ISBN=L.ISBN AND P.IDSOCIO=? AND L.ISBN=?";
			sentencia=con.prepareStatement(ordenSQL);
			sentencia.setLong(1, p.getIdsocio());
			sentencia.setString(2, daoEjemplar.findEjemplarById(p.getIdejemplar()).getIsbn());
			rs = sentencia.executeQuery();
			rs.next();
			if(rs.getInt("NUMEROEJEMPLARES")!=0) {
				throw new PrestamoException("Este socio ya dispone de un ejemplar de este libro");
			}

			//Llegados a este punto, tenemos todas las comprobaciones hechas, solo queda
			//obtener la fecha de devolución, que será por defecto de 5 dias
			LocalDateTime fechaDevolucion = LocalDateTime.now();
			fechaDevolucion = fechaDevolucion.plusDays(3);
			int diaDeLaSemana = fechaDevolucion.getDayOfWeek().getValue();
			if(diaDeLaSemana == 6) { //si es sábado, le añado dos dias
				fechaDevolucion = fechaDevolucion.plusDays(2);
			}else if(diaDeLaSemana == 7) { //si es domingo, le añado un dia
				fechaDevolucion = fechaDevolucion.plusDays(1);
			}

			ordenSQL="INSERT INTO PRESTAMO(IDEJEMPLAR,IDSOCIO,FECHAPRESTAMO,FECHALIMITEDEVOLUCION) VALUES(?,?,SYSDATE,?)";
			sentencia=con.prepareStatement(ordenSQL);
			sentencia.setInt(1,p.getIdejemplar());
			sentencia.setLong(2,p.getIdsocio());
			sentencia.setObject(3, fechaDevolucion);
			sentencia.executeUpdate();
			sentencia.close();
			con.close();
		}catch(SQLException se){
			throw se;
		}catch(Exception e){
			throw e;
		}
		finally{
			if(sentencia!=null)
				sentencia.close();
			if(con!=null)
				con.close();
		}
	}
	/*********************************************************************************************************************************************************/
	public int devolucionPrestamo(int idejemplar)throws SQLException,Exception{
		String ordenSQL;
		int resultado;
		Connection con=null;
		PreparedStatement sentencia=null;
		DaoEjemplar daoEjemplar = new DaoEjemplar();
		try{
			//Comprobar si el ejemplar existe
			if (daoEjemplar.findEjemplarById(idejemplar) == null) {
				throw new PrestamoException("Ejemplar no existe o está dado de baja");
			}
			//Comprobar si el ejemplar está prestado
			Prestamo prestamo = this.findPrestamoById(idejemplar);
			if(prestamo == null) {
				throw new PrestamoException("Imposible hacer la devolución. Este ejemplar no está en prestamo");
			}
			//Ahora solo nos queda comprobar la fecha de devolución por si se ha retrasado
			
			Conexion miconex=new Conexion();
			con=miconex.getConexion();
			if(prestamo.getFechalimitedevolucion().before(java.sql.Date.valueOf(LocalDate.now()))) {
				//penalizar
				ordenSQL = "INSERT INTO SOCIOPENALIZADO VALUES(?,SYSDATE+15)";
				sentencia = con.prepareStatement(ordenSQL);
				sentencia.setLong(1, prestamo.getIdsocio());
				sentencia.executeUpdate();
				
			}
			//borramos el prestamo
			ordenSQL="DELETE FROM PRESTAMO WHERE IDEJEMPLAR=?";
			sentencia=con.prepareStatement(ordenSQL);
			sentencia.setInt(1,idejemplar);
			resultado=sentencia.executeUpdate();
			
			//añadimos una tupla en la tabla devolucion
			ordenSQL = "INSERT INTO DEVOLUCION VALUES(?,?,?,SYSDATE)";
			sentencia=con.prepareStatement(ordenSQL);
			sentencia.setInt(1,idejemplar);
			sentencia.setLong(2, prestamo.getIdsocio());
			sentencia.setObject(3, prestamo.getFechaprestamo());
			sentencia.executeUpdate();
			sentencia.close();
			con.close();
		}catch(SQLException se){
			throw se;
		}catch(Exception e){
			throw e;
		}
		finally{
			if(sentencia!=null)
				sentencia.close();
			if(con!=null)
				con.close();
		}
		return resultado;
	}
	/******************************************************************************************************/
	public ArrayList<Prestamo>listadoPrestamosFueraPlazo(long socio)throws SQLException,Exception{
		String ordenSQL;
		ArrayList<Prestamo> prestamosfueraplazo;
		prestamosfueraplazo = new ArrayList<Prestamo>();
		try{
			Conexion miconex=new Conexion();
			Connection con=miconex.getConexion();
			ordenSQL="SELECT IDEJEMPLAR,IDSOCIO,NOMBRE,TITULO,DIAS_DEMORA,FECHAPRESTAMO "+
					"FROM(SELECT P.IDEJEMPLAR,P.IDSOCIO,S.NOMBRE,L.TITULO,(TRUNC(SYSDATE)-TRUNC(FECHALIMITEDEVOLUCION))DIAS_DEMORA,P.FECHAPRESTAMO "+
					"FROM SOCIO S,PRESTAMO P,EJEMPLAR E,LIBRO L "+
					"WHERE S.IDSOCIO=P.IDSOCIO "+
					"AND P.IDEJEMPLAR=E.IDEJEMPLAR "+
					"AND E.ISBN=L.ISBN "+
					"AND TRUNC(FECHALIMITEDEVOLUCION)<TRUNC(SYSDATE)) "+
					"WHERE IDSOCIO=?";
			PreparedStatement sentencia=con.prepareStatement(ordenSQL);
			sentencia.setLong(1,socio);
			ResultSet rs=sentencia.executeQuery();
			while(rs.next()){
				Prestamo miPrestamo=new Prestamo();
				miPrestamo.setIdejemplar(rs.getInt("IDEJEMPLAR"));
				miPrestamo.setIdsocio(rs.getLong("IDSOCIO"));
				miPrestamo.setNombreSocio(rs.getString("NOMBRE"));
				miPrestamo.setTitulo(rs.getString("TITULO"));
				miPrestamo.setFechaprestamo(rs.getDate("FECHAPRESTAMO"));
				miPrestamo.setDiasDemora(rs.getInt("DIAS_DEMORA"));
				prestamosfueraplazo.add(miPrestamo);
			}
			rs.close();
			sentencia.close();
			con.close();
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}
		return prestamosfueraplazo;
	}

	/******************************************************************************************************/
	public Prestamo findPrestamoById(int idejemplar)throws SQLException,Exception {

		Connection con=null;
		PreparedStatement ps=null;	
		Conexion conexion=new Conexion();
		ResultSet rs= null;
		Prestamo prestamo=null;
		try {
			con=conexion.getConexion();
			ps=con.prepareStatement("SELECT IDEJEMPLAR,IDSOCIO,FECHAPRESTAMO,FECHALIMITEDEVOLUCION "+
					"FROM PRESTAMO "+
					"WHERE IDEJEMPLAR=?");
			ps.setInt(1, idejemplar);
			rs=ps.executeQuery();
			if(rs.next()) {
				prestamo=new Prestamo();
				prestamo.setIdejemplar(rs.getInt("IDEJEMPLAR"));
				prestamo.setIdsocio(rs.getLong("IDSOCIO"));
				prestamo.setFechaprestamo(rs.getDate("FECHAPRESTAMO"));
				prestamo.setFechalimitedevolucion(rs.getDate("FECHALIMITEDEVOLUCION"));	
			}

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		}
		finally{
			if(rs!=null)
				rs.close();
			if(con!=null)
				con.close();
		}        
		return prestamo;
	}

	/***************************FIN DE LA CLASE DaoPrestamo **********************************************************************/
}
