package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
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
		// Obtener la operación que nos piden
		
		String operacion = request.getParameter("operacion");  //¿Que quieres?
		
		
		switch (operacion) {
		case "matricular":
			//Recoger todos los parametros que me mandan
			String nombre = request.getParameter("nombre");
			String apellido1 = request.getParameter("apellido1");
			String apellido2 = request.getParameter("apellido2");
			String email = request.getParameter("email");
			String strFechaNacimiento = request.getParameter("fechanacimiento");
			/**
			 * La fecha viene en un String con formato HTML5
			 * es decir, con formato  año-mes-dia
			 * Preparamos un formatter y lo convertimos a LocalDate
			 */
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fechaNacimiento = LocalDate.parse(strFechaNacimiento,formato);
			/**
			 * En la capa de presentación vamos a utilizar la etiqueta JSTL <fmt:formdate
			 * Para ello necesitamos que el objeto sea de la clase java.sql.Date
			 * Lo transformamos antes de enviarlo
			 * 
			 *  <fmt:formDate pattern="dd-MM-yyyy" value="${fechanacimiento}"/>
			 */
			java.sql.Date fechaNacimientoSqlDate = java.sql.Date.valueOf(fechaNacimiento);
			
			String provinciaNacimiento = request.getParameter("provincianacimiento");
			String emancipado =request.getParameter("emancipado");
			String[] modulosMatriculados = request.getParameterValues("modulos");
			
			//Obtener el dia de la semana
			String diaDeLaSemanaEnIngles = fechaNacimiento.getDayOfWeek().name();
			String diaDeLaSemanaEnCastellano = fechaNacimiento.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.of("es","ES"));
			
			HashMap<String, String> dias = new HashMap<String, String>();
			dias.put("MONDAY", "LUNES");
			dias.put("TUESDAY", "MARTES");
			dias.put("WEDNESDAY", "MIERCOLES");
			dias.put("THURSDAY", "JUEVES");
			dias.put("FRIDAY", "VIERNES");
			dias.put("SATURDAY", "SABADO");
			dias.put("SUNDAY", "DOMINGO");
			String diadelasemana = dias.get(diaDeLaSemanaEnIngles);
			
			//Ahora tenemos que añadir todos los objetos a la request para mandarlo a la página de respuesta
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido1", apellido1);
			request.setAttribute("apellido2", apellido2);
			request.setAttribute("email", email);
			request.setAttribute("provincianacimiento",provinciaNacimiento);
			request.setAttribute("fechanacimiento", fechaNacimientoSqlDate);
			request.setAttribute("diasemananacimiento", diaDeLaSemanaEnCastellano);
			request.setAttribute("emancipado", emancipado);
			request.setAttribute("modulosmatriculados", modulosMatriculados);
			
			//redireccionar a la página de respuesta
			request.getRequestDispatcher("confirmacionmatricula.jsp").forward(request, response);
			
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
		System.out.println("He sido llamado...");
		doGet(request, response);
	}



}
