package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Equipo;
import model.Jugador;
import model.Usuario;
import util.Hash;

import java.io.IOException;
import java.util.List;

import javax.naming.ldap.HasControls;

import daos.DAOEquipo;
import daos.DAOJugador;
import daos.DAOUsuario;

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
		case "login":{
			String email = request.getParameter("email");
			String clave = request.getParameter("clave");
			//buscamos el usuario por si está registrado
			Usuario usuario = DAOUsuario.getUsuario(email);
			
			if (usuario!=null) { //si hay un usuario registrado con ese email
				//compruebo si la clave es correcta
				if(usuario.getClave().equals(Hash.getSha256(clave))) {
					//guardo el objeto usuario dentro de la session
					session.setAttribute("usuario", usuario);
				}
				else {
					//quitar el usuario de la session
					session.removeAttribute("usuario");
				}
			} else {//si no está el usuario registrado
				//aquí tendríamos que enviar un email de registro, etc
				usuario = new Usuario();
				usuario.setEmail(email);
				usuario.setClave(Hash.getSha256(clave));
				DAOUsuario.insertarUsuario(usuario);
				session.setAttribute("usuario", usuario);
			}
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}	
		case "logout":{
			session.removeAttribute("usuario");
			request.getRequestDispatcher("home.jsp").forward(request, response);
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
