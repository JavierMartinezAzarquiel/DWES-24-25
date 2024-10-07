package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.DaoAutor;
import entidades.Autor;

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
