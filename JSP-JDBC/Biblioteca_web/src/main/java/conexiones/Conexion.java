package conexiones;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Conexion {

	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	 public Connection getConexion() throws SQLException,Exception{
//	    	//String url="jdbc:oracle:thin:S2DAWBIBLIOTECA30/S2DAWBIBLIOTECA30@10.0.1.12:1521:oradai";
//	    	String url="jdbc:oracle:thin:S2DAWBIBLIOTECA30/S2DAWBIBLIOTECA30@80.28.158.14:1521:oradai";
//	        Connection con;
//	        OracleDataSource ods;
//	        try{
//
//	        	ods=new OracleDataSource();
//	            ods.setURL(url);
//	            con=ods.getConnection();  // obtenemos un objeto java.sql.Connection
//	            DatabaseMetaData meta = con.getMetaData();
//	            System.out.println("JDBC driver version is " + meta.getDriverVersion());
//	            System.out.println("Data Source definido y conexion establecida");
//	        }
//	        catch(SQLException sqle){
//	            throw sqle;
//	        }
//	        catch(Exception e){
//	            throw e;
//	        }
//	        return con;
	        String JNDI = "jdbc/bibliotecaaza";
			Connection con = null;
			try {
				InitialContext initialContext = new InitialContext();
				DataSource ds = (DataSource) initialContext.lookup(JNDI);
				con = ds.getConnection();
			} catch (SQLException se) {
				throw se;
			} catch (NamingException ne) {
				ne.printStackTrace();
			}
			return con;
	    }

}
