package test;

import java.sql.SQLException;

import dao.DaoAutor;
import entidades.Autor;

public class TestFindAutorById {

	public static void main(String[] args) {
		DaoAutor dao=new DaoAutor();
		try {
			Autor a= dao.findAutorById(1343);
			if(a!=null)
			    System.out.println(a.toString());
			else
				System.out.println("Autor inexistente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
