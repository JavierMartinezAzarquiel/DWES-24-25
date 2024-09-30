package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoSocio;
import entidades.Socio;

public class TestMorosos {

	public static void main(String[] args) {
		DaoSocio dao=new DaoSocio();
		try {
			ArrayList<Socio>listado=dao.listadoSociosMorosos();
			for(Socio s: listado)
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
