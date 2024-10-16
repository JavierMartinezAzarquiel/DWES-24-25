package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Conversor;

import java.io.IOException;

/**
 * Servlet implementation class Controller
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String conversion = request.getParameter("conversion");
		String cantidad = request.getParameter("cantidad");
		
		if (!cantidad.isEmpty()) {
			switch (conversion) {
			case "millasakm":
				float resultado = Conversor.convertirMillasAKm(Float.parseFloat(cantidad));
				request.setAttribute("conversionelegida", conversion);
				request.setAttribute("cantidad", cantidad);
				request.setAttribute("resultado", resultado);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "kmamillas":
				resultado = Conversor.convertirKmAMillas(Float.parseFloat(cantidad));
				request.setAttribute("conversionelegida", conversion);
				request.setAttribute("cantidad", cantidad);
				request.setAttribute("resultado", resultado);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			}
		}else {
			request.setAttribute("conversionelegida", conversion);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
