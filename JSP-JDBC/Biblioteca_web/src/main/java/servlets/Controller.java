package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DaoAutor;
import dao.DaoSocio;
import entidades.Socio;

/**
 * Controller para gestionar solamente el registro de usuarios nuevos
 */
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
		String operacion = request.getParameter("operacion");
		
		switch (operacion) {
		
		case "registrarse":
			//recogemos los datos del formulario
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String clave = request.getParameter("clave");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			
			//insertar una tupla en socio
			Socio socio = new Socio();
			socio.setNombre(nombre);
			socio.setEmail(email);
			socio.setDireccion(direccion);
			socio.setTelefono(telefono);
			DaoSocio daoSocio = new DaoSocio();
			try {
				//insertamos el socio
				daoSocio.insertarSocio(socio,clave);
				request.setAttribute("socio", socio);
				request.getRequestDispatcher("socioregistrado.jsp").forward(request, response);
			} catch (Exception e) {
				procesarError(request, response, e, "error.jsp");
			}
			
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
