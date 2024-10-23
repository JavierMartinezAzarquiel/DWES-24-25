package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoAutor;
import dao.DaoLibro;
import dao.DaoSocio;
import entidades.Autor;
import entidades.Libro;
import entidades.Socio;

/**
 * Servlet implementation class ControllerSocio
 */
@WebServlet("/controllersocio")
public class Controllersocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllersocio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		System.out.println(operacion);
		DaoAutor daoAutor=null;
		
		switch (operacion) {
		
		case "listarAutores":
			System.out.println("Comenzando listado");
			daoAutor=new DaoAutor();
			try {
				List<Autor> listadoautores = daoAutor.listadoAutores();
				request.setAttribute("listadoautores", listadoautores);
				request.getRequestDispatcher("socios/listadoautores.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e,"socios/listadoautores.jsp");}
			  catch (Exception e) {
				procesarError(request, response, e,"socios/listadoautores.jsp");}
			break;
		case "listarAutoresPaginado":
			daoAutor = new DaoAutor();
			int totalRegistros = 0;
			int pagina = 0; //Por defecto muestro la página 0
			int numregpag = 4; //Por defecto le pongo 4
			int paginamasalta = 0;
			List<Autor> listadoAutores = null;
			//Preguntar si tengo parámetros en la request
			if (request.getParameter("pag") != null) { //si nos han pedido una página concreta
				pagina =Integer.parseInt(request.getParameter("pag"));
			}
			if (request.getParameter("nrp") != null) { 
				numregpag =Integer.parseInt(request.getParameter("nrp"));
			}
			
			try {
				//Averiguar cuantos registros hay
				totalRegistros = daoAutor.getTotalRegistros();
				//Calcular cual es la última pagina(pagina mas alta)
				paginamasalta = totalRegistros / numregpag;
				if(totalRegistros % numregpag == 0) paginamasalta--;
				//Obtener el listado de socios
				listadoAutores = daoAutor.listadoAutores(pagina, numregpag);
				
				//añadir todos los datos a la request para mandarselos a la vista
				request.setAttribute("pagina", pagina);
				request.setAttribute("numregpag", numregpag);
				request.setAttribute("paginamasalta", paginamasalta);
				request.setAttribute("totalregistros", totalRegistros);
				request.setAttribute("listadoautores", listadoAutores);
				request.getRequestDispatcher("socios/listadoautoresPaginado.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e,"socios/listadoautoresPaginado.jsp");
			} catch (Exception e) {
				procesarError(request, response, e,"socios/listadoautoresPaginado.jsp");
			}
			break;
			
		case "busquedalibros":
			String criteriobusqueda = request.getParameter("criteriobusqueda");
			String valorbusqueda = request.getParameter("valorbusqueda");
			request.setAttribute("valorbusqueda", valorbusqueda);
			request.setAttribute("criteriobusqueda", criteriobusqueda);
			
			DaoLibro dao = new DaoLibro();
			try {
				ArrayList<Libro> listadoLibros = dao.listadoLibros(criteriobusqueda, valorbusqueda);
				
				request.setAttribute("listadoLibrosBusqueda", listadoLibros);
				request.getRequestDispatcher("socios/getlibros.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e, null);
			} catch (Exception e) {
				procesarError(request, response, e, null);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void procesarError(HttpServletRequest request, HttpServletResponse response, Exception e, String url)	throws ServletException, IOException {
		String mensajeError = e.getMessage();
		request.setAttribute("error", mensajeError);
		if (url == null) {
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}    


}
