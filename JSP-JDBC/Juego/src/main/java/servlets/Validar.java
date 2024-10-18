package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class validar
 */
@WebServlet("/validar")
public class Validar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validar() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Obtener el número que quieren probar
    	int numero = (request.getParameter("numero").equals("")) ? 0 : Integer.parseInt(request.getParameter("numero"));
    	
    	//Obtenemos el objeto Session
    	HttpSession session = request.getSession();
    	//Decir que la sesion no caduca
    	session.setMaxInactiveInterval(-1);
    	
    	//sacar lo atributos de la session
    	Integer intentos = (Integer) session.getAttribute("intentos");
    	Integer secreto = (Integer) session.getAttribute("secreto");
    	
    	String mensaje =""; //variable donde voy a guardar el mensaje de retorno
    	if(intentos == null) { //la session es nueva
    		intentos = 9;
    		secreto = this.crearAleatorio();  //creamos el número aleatorio
    		//añadimos los atributos a la sesion
    		session.setAttribute("secreto", secreto);
    		session.setAttribute("intentos", intentos);
    		
    	}else { //la session es antigua
    		intentos--;
    		session.setAttribute("intentos", intentos);
    	}
    	if(intentos > 0) {//quedan intentos
    		if(numero == secreto) {
    			mensaje="Enhorabuena, has adivinado el numero";
    			session.invalidate();
    		}else {
    			mensaje="Te quedan "+ intentos+" intentos. ";
    			if(secreto>numero) mensaje += "Es mayor.";
    			else mensaje += "Es menor.";
    		}
    		
    	}else {//intentos agotados
    		mensaje="Agotados los 10 intentos, se iniciará un nuevo juego";
    		session.invalidate(); //cerramos la session
    	}
    	
    	//retorno a la página
    	request.setAttribute("resultado", mensaje);
    	request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("<title> Petición POST número "+(contador++)+"</title>");
		doGet(request,response);
	}

	
	private int crearAleatorio() {
		int numero=(int)(Math.random()*50+1);
		System.out.println(" Número aleatorio "+numero);
		return numero;
	}

}
