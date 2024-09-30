package test;

import java.sql.Connection;
import java.sql.SQLException;

import conexiones.Conexion;

public class TestConexion {

	public static void main(String[] args) {
    Conexion conexion=new Conexion();
    try {
		Connection con=conexion.getConexion();
		System.out.println(con.getSchema());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
