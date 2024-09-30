package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Controller09
 */
public class Controller09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int contador=1; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller09() {
        super();
        // TODO Auto-generated constructor stub
    }

	// MUY IMPORTANTE: No se puede usar como solución la carga de una variable boolean y dopost y doget y en función del
    // valor poner un mensaje u otro porque hay que tener presente que doGet lo ejecuta cada uno de los hilos que atiende
    // cada petición y el resultado del acceso concurrente de todos los hilos a dicha variable tendría un resultado impredecible
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
		// TODO Auto-generated method stub
		//System.out.println("Esto lo ejecuta el hilo "+Thread.currentThread());
		// Busca la configuración del número de hilos del pool en 
		// localhost:4848 configuracion default-config Thread Pools
		HttpSession sesion=request.getSession();
		sesion.setMaxInactiveInterval(60*3); // sesión 3 minutos
		Integer contadorSesion=(Integer)sesion.getAttribute("contador-sesion");
		if (contadorSesion==null) contadorSesion=1;
		else ++contadorSesion;
		sesion.setAttribute("contador-sesion",contadorSesion);
		if (sesion.isNew()) System.out.println(" Sesión nueva con id"+sesion.getId());
		int F=Integer.parseInt(request.getParameter("filas"));
		int C=Integer.parseInt(request.getParameter("columnas"));
		if (F>7 || C>7) {
			response.sendRedirect("error6.html");
		}
		// Si recibo una petición en la que han seleccionado grabar preferencias
		// generaré las cookies fila y columna
		// Dejo al cliente que lee las cookies y rellene el formulario con los datos leidos
		// cuando sepamos crear páginas JSP, lo haremos del lado del servidor
		boolean grabar=request.getParameter("grabar").equals("si")?true:false;
		System.out.println(request.getParameter("grabar"));
		if (grabar) {
			System.out.println("grabo una cookie");
			Cookie cfila=new Cookie("filas",""+F);
			cfila.setMaxAge(60*10); // 10 minutos
			Cookie ccolumna=new Cookie("columnas",""+C);
			ccolumna.setMaxAge(60*10); // 10 minutos
			response.addCookie(cfila);
			response.addCookie(ccolumna);
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(" GENERAL ["+(contador++)+"] LOCAL ["+contadorSesion+"]");
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
