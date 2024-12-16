package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Equipo;
import model.Jugador;

import java.io.IOException;
import java.util.List;

import daos.DAOEquipo;
import daos.DAOJugador;

/**
 * Servlet implementation class Controller1
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
		HttpSession session = request.getSession();
		String op = request.getParameter("op");

		switch (op) {
		case "inicio": {
			List<Equipo> equipos = DAOEquipo.getEquipos();

			session.setAttribute("equipos", equipos);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "equipo": {
			String idequipo = request.getParameter("idequipo");

			Equipo equipo = DAOEquipo.getEquipo(Long.parseLong(idequipo));
			session.setAttribute("equipo", equipo);
			request.getRequestDispatcher("jugadores.jsp").forward(request, response);
			break;
		}
		case "like": {
			String idjugador = request.getParameter("idjugador");
			
			Jugador jugador = DAOJugador.getJugador(Long.parseLong(idjugador));

			int likes = jugador.getLikes();
			likes++;
			jugador.setLikes(likes);
			DAOJugador.actualizarJugador(jugador);
			Equipo equipo = (Equipo) session.getAttribute("equipo");
			equipo = DAOEquipo.getEquipo(equipo.getId());
			session.setAttribute("equipo", equipo);
			request.getRequestDispatcher("jugadores.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
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
