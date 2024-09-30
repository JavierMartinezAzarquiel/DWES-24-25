package conexiones;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Conexion {

	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	 public Connection getConexion() throws SQLException,Exception{
	    	//String url="jdbc:oracle:thin:S2DAWBIBLIOTECA30/S2DAWBIBLIOTECA30@10.0.1.12:1521:oradai";
	    	String url="jdbc:oracle:thin:S2DAWBIBLIOTECA30/S2DAWBIBLIOTECA30@80.28.158.14:1521:oradai";
	        Connection con;
	        OracleDataSource ods;
	        try{

	        	ods=new OracleDataSource();
	            ods.setURL(url);
	            con=ods.getConnection();  // obtenemos un objeto java.sql.Connection
	            DatabaseMetaData meta = con.getMetaData();
	            System.out.println("JDBC driver version is " + meta.getDriverVersion());
	            System.out.println("Data Source definido y conexion establecida");
	        }
	        catch(SQLException sqle){
	            throw sqle;
	        }
	        catch(Exception e){
	            throw e;
	        }
	        return con;
	    }

}
