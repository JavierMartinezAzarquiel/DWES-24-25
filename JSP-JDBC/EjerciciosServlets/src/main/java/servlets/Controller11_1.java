package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller11_1
 */
public class Controller11_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller11_1() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("<title> Petición GET número "+(contador++)+"</title>");
		doHacer(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("<title> Petición POST número "+(contador++)+"</title>");
		doHacer(request,response);
	}

	private void doHacer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se encarga de leer los parámetros y hacer la validación
		// una vez realizada se lo pasa a controller11_2 
		// en esta ocasión, en vez de pasar la request, pasa dos objetos integer con 
		// filas y columnas
		int F=Integer.parseInt(request.getParameter("filas"));
		int C=Integer.parseInt(request.getParameter("columnas"));
		if (F>7 || C>7) 
			response.sendRedirect("error6.html");
		else {
			Integer filas = F;
			Integer columnas = C;
			request.setAttribute("filas", filas);
			request.setAttribute("columnas", columnas);
			// Se puede acceder de varias formas, via contexto
			RequestDispatcher rs=getServletContext().getRequestDispatcher("/controller11_2");
			// o via objeto request 
			//RequestDispatcher rs = request.getRequestDispatcher("/controller11_2");
			rs.forward(request, response);
		}
			
	}


}
