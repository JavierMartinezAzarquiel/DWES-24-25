package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pool.PoolSocio;

import java.io.IOException;
import java.io.PrintWriter;

import entidades.Socio;

/**
 * Servlet implementation class Controller12
 */
public class Controller12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// No tiene mucho sentido crear almacenar aquí lo socios
		// lo hacemos como una aproximación al almacenamiento en BBDD
	    private PoolSocio poolsocios;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller12() {
        super();
     // No tiene mucho sentido crear almacenar aquí lo socios
    	// lo hacemos como una aproximación al almacenamiento en BBDD
        poolsocios=new PoolSocio();
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
		// Ya explicaré en la sección tools por qué pongo ésto
		request.setCharacterEncoding("utf-8");
		String operacion=request.getParameter("operacion");
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String nif=request.getParameter("nif");
		String email=request.getParameter("email");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(" Número total de socios antes de la operación de "+operacion+" "+poolsocios.numeroSocios()+"<br><br>");
		boolean resultado=false;
		Socio s=null;
		switch (operacion) {
			case "alta":
				s=new Socio();
				s.setNombre(nombre);
				s.setApellidos(apellidos);
				s.setNif(nif);
				s.setEmail(email);
				resultado=poolsocios.altaSocio(s);
				if (resultado)
					out.println(" Socio dado de alta con id "+s.getIdsocio());
				else 
					out.println(" Ya existe un socio con el nif "+s.getNif());
				break;
			case "baja":
				resultado=poolsocios.bajaSocio(nif);
				out.print(" Socio con el nif "+nif);
				if (!resultado) out.print(" no");
				out.println(" ha podido darse de baja");
				break;
			case "consulta":
				s=poolsocios.buscaSocio(nif);
				if (s==null) out.println(" No existe socio con el nif "+nif);
				else 
					out.println(" los datos del socio son "+s);
				
		}
		out.println("<br><br> Número total de socios después de la operación de "+operacion+" "+poolsocios.numeroSocios()+"<br><br>");
	}


}
