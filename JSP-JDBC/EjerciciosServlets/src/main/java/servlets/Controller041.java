package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Controller041
 */
public class Controller041 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller041() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<title> Petición GET </title>");
		doHacer(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<title> Petición POST </title>");
		doHacer(request,response);

	}
	
	private void doHacer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Esto lo ejecuta el hilo "+Thread.currentThread());
		// Busca la configuración del número de hilos del pool en 
		// localhost:4848 configuracion default-config Thread Pools
		int F=Integer.parseInt(request.getParameter("filas"));
		int C=Integer.parseInt(request.getParameter("columnas"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<TABLE border=1>");
		for (int i=1;i<=F;i++) {
			out.println("\t\t<tr>");
			for (int j=1;j<=C;j++) 
				out.println("\t\t\t<td>"+((i-1)*C+j)+"</td>");
			out.println("\t\t</tr>");
		}
		out.println("</TABLE>");
	}

}
