package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Bici;
import model.Marca;
import daos.DAOBici;
import daos.DAOMarca;


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
		ArrayList<Marca> marcas = null;
		ArrayList<Bici> bicis = null;
		String idmarca="0";
		String orden="null";
		int favoritas=0;

		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
		
		
		switch (operacion) {
		case "inicio": {
			// actuar en consecuencia
			try {
				marcas = new DAOMarca().getAllMarcas();
				bicis = new DAOBici().getBicis(0, "null",0);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("marcas", marcas);
			request.setAttribute("bicis", bicis);
			session.setAttribute("favoritas", favoritas);
			session.setAttribute("idmarca", idmarca);
			session.setAttribute("orden", orden);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "cambiomarca": {
			idmarca = request.getParameter("idmarca"); //recogemos la marca seleccionada
			session.setAttribute("idmarca", idmarca); //la guardo en la session
			orden = (String) session.getAttribute("orden");
			favoritas = (Integer)session.getAttribute("favoritas");
			// actuar en consecuencia
			try {
				bicis = new DAOBici().getBicis(Integer.parseInt(idmarca), orden ,favoritas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bicis", bicis);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "cambioorden": {
			orden = request.getParameter("orden");
			session.setAttribute("orden", orden);
			favoritas = (Integer)session.getAttribute("favoritas");
			idmarca = (String) session.getAttribute("idmarca");
			// actuar en consecuencia
			try {
				bicis = new DAOBici().getBicis(Integer.parseInt(idmarca), orden,favoritas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bicis", bicis);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "favoritas":{
			favoritas = (Integer)session.getAttribute("favoritas");
			int nuevofav = (favoritas==0)?1:0;
			session.setAttribute("favoritas", nuevofav);
			idmarca = (String) session.getAttribute("idmarca");
			orden = (String) session.getAttribute("orden");
			try {
				bicis = new DAOBici().getBicis(Integer.parseInt(idmarca), orden, nuevofav);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bicis", bicis);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "bicifavorita": {
			String idbici = request.getParameter("idbici");
			String bicifav = request.getParameter("bicifav");
			
			idmarca = (String) session.getAttribute("idmarca");
			orden = (String) session.getAttribute("orden");
			favoritas = (Integer)session.getAttribute("favoritas");
			
			try {
				new DAOBici().changeFav(Integer.parseInt(bicifav), Integer.parseInt(idbici));
				bicis = new DAOBici().getBicis(Integer.parseInt(idmarca), orden, favoritas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bicis", bicis);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
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
