package conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class Conexion {
    public Connection getConexion() throws SQLException{
		// change username password please
		// 80.28.158.14 ip donde se ubica el Oracle Server del Azarquiel
		// 1521:oradai, puerto default Oracle y servicio creado en este Server 
    	String url="jdbc:oracle:thin:foster/foster@80.28.158.14:1521:oradai";
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
