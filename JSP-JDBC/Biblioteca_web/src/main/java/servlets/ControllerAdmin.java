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
import java.util.ArrayList;
import java.util.List;

import dao.DaoAutor;
import dao.DaoPrestamo;
import dao.DaoSocio;
import entidades.Autor;
import entidades.Prestamo;
import entidades.Socio;

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
		//OBTENGO EL OBJETO SESSION
		HttpSession session = request.getSession();
		
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
			
		case "registrarse":
			System.out.println("Entrando en registrarse....");
			nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String clave = request.getParameter("password");
			String direccion = request.getParameter("direccion");

			DaoSocio daosocio = new DaoSocio();
			Socio socio = new Socio();
			socio.setNombre(nombre);
			socio.setEmail(email);
			socio.setClave(clave);
			socio.setDireccion(direccion);
			try {
				daosocio.insertarSocio(socio);
				//recuperamos el socio que ya vendrá con el ID completo
				socio = daosocio.findSocioByEmail(socio.getEmail());
				request.setAttribute("socio", socio);
				request.setAttribute("confirmaroperacion", "Socio "+socio.getIdsocio()+" creado satisfactoriamente");
				request.getRequestDispatcher("admin/altasocio.jsp").forward(request, response);
			} catch (SQLException e) {
				System.out.println(e.toString());
				procesarError(request, response, e,"admin/altasocio.jsp");
			} catch (Exception e) {
				procesarError(request, response, e,"admin/altasocio.jsp");
			}
			break;
			
		case "listadoSociosPaginado":
			DaoSocio daoSocio = new DaoSocio();
			int totalRegistros = 0;
			int pagina = 0; //Por defecto muestro la página 0
			int numregpag = 5; //Por defecto le pongo 5
			int paginamasalta = 0;
			List<Socio> listadoSocios = null;
			//Preguntar si tengo parámetros en la request
			if (request.getParameter("pag") != null) { //si nos han pedido una página concreta
				pagina =Integer.parseInt(request.getParameter("pag"));
			}
			if (request.getParameter("nrp") != null) { 
				numregpag =Integer.parseInt(request.getParameter("nrp"));
			}
			
			try {
				//Averiguar cuantos registros hay
				totalRegistros = daoSocio.getTotalRegistros();
				//Calcular cual es la última pagina(pagina mas alta)
				paginamasalta = totalRegistros / numregpag;
				if(totalRegistros % numregpag == 0) paginamasalta--;
				//Obtener el listado de socios
				listadoSocios = daoSocio.listadoSocios(pagina, numregpag);
				
				//añadir todos los datos a la request para mandarselos a la vista
				request.setAttribute("pagina", pagina);
				request.setAttribute("numregpag", numregpag);
				request.setAttribute("paginamasalta", paginamasalta);
				request.setAttribute("totalregistros", totalRegistros);
				request.setAttribute("listadoSocios", listadoSocios);
				request.getRequestDispatcher("admin/listadosociospaginado.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e,"admin/listadosociospaginado.jsp");
			} catch (Exception e) {
				procesarError(request, response, e,"admin/listadosociospaginado.jsp");
			}
			
			
			
			break;	
		case "busquedasocio":
			String iniciales = request.getParameter("frmbusquedanombre");
			System.out.println(iniciales);
			daoSocio = new DaoSocio();
			try {
				listadoSocios = daoSocio.listadoSociosByNombre(iniciales);
				System.out.println(listadoSocios);
				request.setAttribute("iniciales", iniciales);
				request.setAttribute("listadoSociosBusqueda", listadoSocios);
				request.getRequestDispatcher("admin/getsocio.jsp").forward(request, response);
			} catch (SQLException e) {		
				procesarError(request, response, e, "admin/getsocio.jsp");
				//e.printStackTrace();
			} catch (Exception e) {
				procesarError(request, response, e, "admin/getsocio.jsp");
			}
			break;	
		case "editarsocio":
			long idsocio = Long.parseLong(request.getParameter("socio"));
			daoSocio = new DaoSocio();
			try {
				socio = daoSocio.findSocioById(idsocio);
				request.setAttribute("socioenproceso", socio);
				request.getRequestDispatcher("admin/editsocio.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e, null);
			} catch (Exception e) {
				procesarError(request, response, e, null);
			}
			break;
		case "updatesocio":
			socio = new Socio();
			Long codigoSocio = Long.decode(request.getParameter("frmeditSocioIdSocio"));
			socio.setIdsocio(codigoSocio);
			socio.setNombre(request.getParameter("frmeditSocioNombre"));
			socio.setDireccion(request.getParameter("frmeditSocioDireccion"));
			daoSocio = new DaoSocio();
			try {
				request.setAttribute("socioenproceso", socio);
				daoSocio.updateSocio(socio);
				Socio sociomodificado=daoSocio.findSocioById(socio.getIdsocio());
				request.setAttribute("socioenproceso", sociomodificado);
				request.setAttribute("confirmaroperacion", "Socio modificado");
				request.getRequestDispatcher("admin/editsocio.jsp").forward(request, response);
			} catch (SQLException sqlexc) {
				System.out.println("que pasa en sqlexception....");
				procesarError(request, response, sqlexc, "admin/editsocio.jsp");
			} catch (Exception e) {
				procesarError(request,response,e,"admin/editsocio.jsp");
				// procesarError(request,response,e);
			}
			break;	
			
		case "socioslibrosfueraplazo":
			daosocio = new DaoSocio();
			try {
				listadoSocios = daosocio.listadoSociosMorosos();
				session.setAttribute("listadoSociosMorosos", listadoSocios);
				request.getRequestDispatcher("admin/listadosociosmorosos.jsp").forward(request, response);
			} catch (SQLException e) {
				procesarError(request, response, e, null);
			} catch (Exception e) {
				procesarError(request, response, e, null);
			}
			break;
		case "verlibrosfueraplazo":
			//vuelvo a cargar el listado de sociosMorosos
			daosocio = new DaoSocio();
//			try {
//				listadoSocios = daosocio.listadoSociosMorosos();
//				request.setAttribute("listadoSociosMorosos", listadoSocios);
//			} catch (SQLException e) {
//				procesarError(request, response, e, null);
//
//			} catch (Exception e) {
//				procesarError(request, response, e, null);
//			}
			codigoSocio = Long.parseLong(request.getParameter("socio"));
			ArrayList<Prestamo>listadoPrestamos;
			DaoPrestamo daoprestamo = new DaoPrestamo();
			try {
				
				listadoPrestamos = daoprestamo.listadoPrestamosFueraPlazo(codigoSocio);
				request.setAttribute("nombreSocio", daosocio.findSocioById(codigoSocio).getNombre());
				request.setAttribute("listadoLibrosFueraPlazo", listadoPrestamos);
				request.getRequestDispatcher("admin/listadosociosmorosos.jsp").forward(request, response);
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

	protected void procesarError(HttpServletRequest request, HttpServletResponse response, Exception e, String url) throws ServletException, IOException {
		String mensajeError = e.getMessage();
		request.setAttribute("error", mensajeError);
		if(url == null) {
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

}
