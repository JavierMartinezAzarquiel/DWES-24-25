package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;



import conexion.Conexion;
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
		ArrayList<Categoria> categorias =null;
		ArrayList<Producto> productos =null;
		
		switch (operacion) {
		case "iniciar": {
			try {
				categorias = new DAOCategoria().getAllCategorias();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("categorias", categorias);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "obtenerplatos":
		{
			String idcategoria = request.getParameter("idcategoria");
			String nombrecategoria = request.getParameter("nombrecategoria");
			try {
				productos = new DAOProducto().getProductosByCategoria(Integer.parseInt(idcategoria));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("productos", productos);
			session.setAttribute("nombrecategoria", nombrecategoria);
			request.getRequestDispatcher("home.jsp").forward(request, response);
						
			break;
		}
		case "rating":{
			String puntos = request.getParameter("puntos");
			String idproducto = request.getParameter("idproducto");
			
			Punto punto = new Punto(100, Integer.parseInt(idproducto), Integer.parseInt(puntos));
			try {
				new DAOPunto().insertaPunto(punto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String msg = "Anotados "+puntos+ " puntos a "+ idproducto;
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
