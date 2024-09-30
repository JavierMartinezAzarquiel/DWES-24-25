package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoSocio;
import entidades.Socio;

public class TestBusquedaSociosPorNombre {

	public static void main(String[] args) {
		ArrayList<Socio>listado=null;
		DaoSocio dao=new DaoSocio();
		try {
			listado=dao.listadoSociosByNombre("socio 12");
			for(Socio s:listado)
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
