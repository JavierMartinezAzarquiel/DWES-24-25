package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAutor;
import dao.DaoSocio;
import entidades.Autor;
import entidades.Socio;

public class TestListadoPaginado {

	public static void main(String[] args) {
		List<Socio>socios;
		DaoSocio dao=new DaoSocio();
		List<Autor>autores;
		DaoAutor daoA=new DaoAutor();
		try {
			socios=dao.listadoSocios(0, 5);
			for(Socio s: socios)
				System.out.println(s.toString());
			autores=daoA.listadoAutores(0, 5);
			for(Autor a: autores)
				System.out.println(a.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
