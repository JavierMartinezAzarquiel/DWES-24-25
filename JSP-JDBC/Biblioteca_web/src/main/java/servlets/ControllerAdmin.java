package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dao.DaoAutor;
import entidades.Autor;

/**
 * Servlet implementation class ControllerAdmin
 */
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtenemos la operación que han seleccionado en el menu
		String operacion = request.getParameter("operacion");	
		
		DaoAutor daoAutor = null;  //variable dao para autores
		
		switch (operacion) {
		
		case "insertaautor":
			//me han pedido insertar un autor. Lo primero será crear el autor con los campos que vengan en la request
			String nombre =request.getParameter("nombre");
			String strFechaNacimiento = request.getParameter("fechaNacimiento");
			
			//transformamos la fecha a java.sql.Date
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(strFechaNacimiento,formato);
			Date  fechaEnSql = java.sql.Date.valueOf(localDate);
			
			//creamos el objeto Autor
			Autor autor = new Autor();
			autor.setNombre(nombre);
			autor.setFechaNacimiento(fechaEnSql);
			
			//creamos el objeto DAO
			daoAutor = new DaoAutor();
			
			try {
				//insertamos
				daoAutor.insertaAutor(autor);
				
				//ofrezco una respuesta
				request.setAttribute("confirmaroperacion", "Autor creado satisfactoriamente");
				request.getRequestDispatcher("admin/altaautor.jsp").forward(request, response); //redirecciono
			} catch (SQLException e) {
				procesarError(request, response, e, "admin/altaautor.jsp");
			} catch (Exception e) {
				procesarError(request, response, e, "admin/altaautor.jsp");
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

	protected void procesarError(HttpServletRequest request, HttpServletResponse response, Exception e, String url) throws ServletException, IOException {
		String mensajeError = e.getMessage();
		request.setAttribute("error", mensajeError);
		if(url == null) {
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
