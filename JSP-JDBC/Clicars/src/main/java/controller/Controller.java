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

import model.Coche;
import model.Marca;
import daos.DAOCoche;
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
                
		ArrayList<Marca> marcas=null;
        ArrayList<Coche> coches=null;
		
		switch (operacion) {
		case "inicio": {
			try {
				coches = new DAOCoche().getCoches();
				marcas = new DAOMarca().getMarcas();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            session.setAttribute("idmarca", 0);
			session.setAttribute("marcas", marcas);
            session.setAttribute("coches", coches);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "cambiomarca": {
            String idmarca = request.getParameter("idmarca");
            try {
				coches = new DAOCoche().getCoches(Integer.parseInt(idmarca));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         
                        
            session.setAttribute("idmarca", idmarca);
            session.setAttribute("coches", coches);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}  
		case "cambioorden": {
			String orden = request.getParameter("orden");
			session.setAttribute("orden", orden);
			String idmarca = String.valueOf(session.getAttribute("idmarca"));
			
			try {
				coches = new DAOCoche().getCoches(Integer.parseInt(idmarca),orden);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
			session.setAttribute("orden", orden);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "like": {
			String idcoche = request.getParameter("idcoche");
			String idmarca = String.valueOf(session.getAttribute("idmarca"));
			String orden = (String) session.getAttribute("orden");
			try {
				new DAOCoche().addLike(Integer.valueOf(idcoche));
				coches = new DAOCoche().getCoches(Integer.parseInt(idmarca),orden);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("coches", coches);
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
