package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
       if(daoEjemplar.findEjemplarById(p.getIdejemplar())==null)
    	   throw new PrestamoException("Ejemplar no existente o dado de baja");  
        Prestamo prestamo = findPrestamoById(p.getIdejemplar());    
       if(prestamo!=null)
			throw new PrestamoException("Préstamo duplicado. El ejemplar indicado está en préstamo");
        try{
            Conexion miconex=new Conexion();
            con=miconex.getConexion();
            ordenSQL="INSERT INTO PRESTAMO(IDEJEMPLAR,IDSOCIO,FECHAPRESTAMO) VALUES(?,?,SYSDATE)";
            sentencia=con.prepareStatement(ordenSQL);
            sentencia.setInt(1,p.getIdejemplar());
            sentencia.setLong(2,p.getIdsocio());
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
    public int borraPrestamo(int codigoejemplar)throws SQLException,Exception{
       String ordenSQL;
       int resultado;
       Connection con=null;
       PreparedStatement sentencia=null;
       try{
            Conexion miconex=new Conexion();
            con=miconex.getConexion();
            ordenSQL="DELETE FROM PRESTAMO WHERE IDEJEMPLAR=?";
            System.out.println("La ORDEN DE BORRADO ES: "+ordenSQL);
            sentencia=con.prepareStatement(ordenSQL);
            sentencia.setInt(1,codigoejemplar);
            resultado=sentencia.executeUpdate();
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
