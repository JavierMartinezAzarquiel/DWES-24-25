package test;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoEjemplar;
import entidades.Ejemplar;

public class TestListadoEjemplaresDisponibles {

	public static void main(String[] args) {
		DaoEjemplar dao=new DaoEjemplar();
		try {
			ArrayList<Ejemplar>disponibles=dao.getEjemplaresDisponibles("003");
			for(Ejemplar e:disponibles)
				System.out.println(e.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			


	}

}
