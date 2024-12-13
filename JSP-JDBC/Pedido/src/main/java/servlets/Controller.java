package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import carrocompra.CarroCompra;
import dao.DaoProducto;
import entidades.Producto;
import excepciones.ClienteException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	protected void procesarError(HttpServletRequest request,
			HttpServletResponse response, Exception e) throws ServletException,
			IOException {
		String mensajeError = e.getMessage();
		request.setAttribute("error", mensajeError);
		request.getRequestDispatcher("error.jsp").forward(request,response);

	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @param e
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procesarErrorSQL(HttpServletRequest request, 
            HttpServletResponse response, 
            SQLException e,
            String url) throws ServletException, IOException {
		String mensajeErrorUsuario = e.getMessage();
		request.setAttribute("error", mensajeErrorUsuario);
		if (url == null) {
			url = "admin/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		System.out.println(operacion);
		CarroCompra carroCliente = null;
		HttpSession session = request.getSession(true);
		long idProducto;
		DaoProducto dao = new DaoProducto();
		switch(operacion){
		case "comprar":
			carroCliente = (CarroCompra) session.getAttribute("carroCliente");
			if (carroCliente == null) {
				carroCliente = new CarroCompra();
				session.setAttribute("carroCliente", carroCliente);
			}
			
			ArrayList<Producto> listaProductos = null;
			try {
				listaProductos = dao.listadoProductos();
				//session.setAttribute("listadoProductos", listaProductos);
				request.setAttribute("listadoProductos", listaProductos);
				request.getRequestDispatcher("compra.jsp").forward(request,
						response);				
			} catch (SQLException e) {
				procesarError(request, response, e);
			} catch (Exception e) {
				procesarError(request, response, e);
			}

		    break;
		case "addproducto":
			idProducto = Long.parseLong(request.getParameter("producto"));
			carroCliente = (CarroCompra) session.getAttribute("carroCliente");
			DaoProducto daoprod = new DaoProducto();
			Producto producto=null;
			try {
				carroCliente.addElemento(idProducto);
				//session.setAttribute("carroCliente", carroCliente);
				//En java no hace falta volver a guardar
				//tenemos la referencia a la variable de sesión
				// y la puedo modificar porque se trata de un objeto mutable.
				listaProductos = dao.listadoProductos();
				request.setAttribute("listadoProductos", listaProductos);
				request.getRequestDispatcher("compra.jsp").forward(request,
						response);				
			} catch (SQLException e) {
				procesarErrorSQL(request, response, e,"prueba.jsp");
			} catch (Exception e) {
				procesarError(request, response, e);
			}

		break;
		case "restarcantidadproducto":
			idProducto = Long.parseLong(request.getParameter("producto"));
			carroCliente = (CarroCompra) session.getAttribute("carroCliente");
			try {
				carroCliente.restarElemento(idProducto);
				listaProductos = dao.listadoProductos();
				request.setAttribute("listadoProductos", listaProductos);
				request.getRequestDispatcher("compra.jsp").forward(request,
						response);
			} catch (SQLException sqle) {
				procesarErrorSQL(request, response, sqle,"compra.jsp");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case "eliminarproducto":
			idProducto = Long.parseLong(request.getParameter("producto"));
			carroCliente = (CarroCompra) session.getAttribute("carroCliente");

			try {
				carroCliente.eliminarElementoCarro(idProducto);
				listaProductos = dao.listadoProductos();
				request.setAttribute("listadoProductos", listaProductos);
				request.getRequestDispatcher("compra.jsp").forward(request,
						response);
				
			} catch (SQLException sqle) {
				procesarErrorSQL(request, response, sqle,"compra.jsp");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "validarygrabarpedido":
			try {
			    long idcliente=Long.parseLong(request.getParameter("idcliente"));
				String direccionCliente=request.getParameter("direccion");
				carroCliente = (CarroCompra) session.getAttribute("carroCliente");
				carroCliente.crearPedido(idcliente, direccionCliente);
				session.removeAttribute("carroCliente");
				request.getRequestDispatcher("index.html").forward(request,
						response);
			}catch(NumberFormatException e){
			      String mensajeError="Id debe ser numérico";
				  request.setAttribute("error",mensajeError);
				  request.getRequestDispatcher("getdatospedido.jsp").forward(request,
							response);
			} catch (ClienteException e) {
				  System.out.println("Ha entrado en ClienteException");
			      String mensajeError=e.getMessage();
				  request.setAttribute("error",mensajeError);
				  request.getRequestDispatcher("getdatospedido.jsp").forward(request,
							response);
			} catch (SQLException e) {
				procesarError(request, response, e);
			} catch (Exception e) {
				procesarError(request, response, e);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
