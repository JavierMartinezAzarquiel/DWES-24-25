package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoSocio;
import entidades.Socio;

public class TestListadoPaginado {

	public static void main(String[] args) {
		List<Socio>socios;
		DaoSocio dao=new DaoSocio();
		try {
			socios=dao.listadoSocios(4, 5);
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
