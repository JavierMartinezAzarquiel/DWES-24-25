package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoSocio;
import entidades.Socio;

public class TestBusquedaSocio {

	public static void main(String[] args) {
		ArrayList<Socio>socios;
		DaoSocio dao=new DaoSocio();
		try {
			socios=dao.listadoSociosByNombre("1");
			for(Socio s: socios)
				System.out.println(s.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
