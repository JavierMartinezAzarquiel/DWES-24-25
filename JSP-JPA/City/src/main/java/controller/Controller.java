package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Ciudad;
import model.Punto;
import model.Ruta;
import daos.DAOCiudad;
import daos.DAOPunto;
import daos.DAORuta;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ciudad> ciudades = null;
		List<Ciudad> ciudadesrutas = null;
		
		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
		
		switch (operacion) {
		case "inicio": 
			ciudades = DAOCiudad.getCiudades();
			ciudadesrutas = DAOCiudad.getCiudadesConRutas();
			request.setAttribute("ciudades", ciudades);
			session.setAttribute("ciudadesrutas", ciudadesrutas);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		
		case "rutaelegida":
			String idciudad =request.getParameter("idciudad");
			List<Ruta> listaRutas=null;
			String nombreciudad=null;
			Ciudad c = DAOCiudad.getCiudad(Long.parseLong(idciudad));  
			listaRutas = c.getRutas();
			nombreciudad = c.getNombre();
			session.setAttribute("listarutas", listaRutas);
			session.setAttribute("idciudad", idciudad);
			session.setAttribute("ciudad", nombreciudad );
			request.getRequestDispatcher("home.jsp").forward(request, response);
		break;
		case "rating":
			String puntos = request.getParameter("rating");
			String rutaid = request.getParameter("idruta");
			Punto punto = new Punto();
			punto.setId(100);
			punto.setPuntos(Integer.parseInt(puntos));
			punto.setRutaBean(DAORuta.getRuta(Long.parseLong(rutaid)));
			System.out.println(punto);
			idciudad =(String)session.getAttribute("idciudad");
			listaRutas=null;
			DAOPunto.insertPunto(punto);
			listaRutas = DAOCiudad.getCiudad(Long.parseLong(idciudad)).getRutas();
			session.setAttribute("listarutas", listaRutas);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		case "ciudades":
			ciudades = DAOCiudad.getCiudades();
			ciudadesrutas = DAOCiudad.getCiudadesConRutas();
			request.setAttribute("ciudades", ciudades);
			session.setAttribute("ciudadesrutas", ciudadesrutas);
			session.removeAttribute("listarutas");
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + operacion);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
