package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import daos.DAOCategoria;
import daos.DAOProducto;
import daos.DAOPunto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Categoria;
import model.Producto;
import model.Punto;


/**
 * Servlet implementation class Controller
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
		String operacion = request.getParameter("operacion");
		List<Categoria> categorias =null;
		List<Producto> productos =null;
		
		switch (operacion) {
		case "iniciar": {
		
			categorias = new DAOCategoria().getAllCategorias();
			
			session.setAttribute("categorias", categorias);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "obtenerplatos":
		{
			String idcategoria = request.getParameter("idcategoria");
			String nombrecategoria = request.getParameter("nombrecategoria");
			
			productos = new DAOProducto().getProductosByCategoria(Long.parseLong(idcategoria));
			
			session.setAttribute("productos", productos);
			session.setAttribute("nombrecategoria", nombrecategoria);
			request.getRequestDispatcher("home.jsp").forward(request, response);
						
			break;
		}
		case "rating":{
			String puntos = request.getParameter("puntos");
			String idproducto = request.getParameter("idproducto");
			
			Punto punto = new Punto();
			punto.setPuntos(Integer.parseInt(puntos));
			Producto p = new DAOProducto().getProductoById(Long.parseLong(idproducto));
			punto.setProducto(p); //obtener un producto y guardarlo dentro de punto
			
			new DAOPunto().insertaPunto(punto);
			
			String msg = "Anotados "+puntos+ " puntos a  "+ idproducto;
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operacion);
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
