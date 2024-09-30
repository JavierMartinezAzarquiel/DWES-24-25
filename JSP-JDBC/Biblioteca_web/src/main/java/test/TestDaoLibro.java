package test;

import java.util.ArrayList;

import dao.DaoLibro;
import entidades.Libro;

public class TestDaoLibro {

	public static void main(String[] args) {
		DaoLibro dao=new DaoLibro();
		try {
			ArrayList<Libro>listado=dao.listadoLibros("autor", "zafón");
			for (Libro l:listado)
				System.out.println(l.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
