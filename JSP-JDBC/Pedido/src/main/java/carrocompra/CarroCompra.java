package carrocompra;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import conexiones.Conexion;
import dao.DaoCliente;
import dao.DaoDetallePedido;
import dao.DaoPedido;
import dao.DaoProducto;
import entidades.Cliente;
import entidades.DetallePedido;
import entidades.Pedido;
import entidades.ProductoCarro;
import excepciones.ClienteException;

public class CarroCompra {
	private ArrayList<ProductoCarro> elementos;

	public CarroCompra() {
		elementos = new ArrayList<ProductoCarro>();
	}

	public void setElementos(ArrayList<ProductoCarro> elementos) {
		this.elementos = elementos;
	}

	public ArrayList<ProductoCarro> getElementos() {
		return elementos;
	}

	/*************************************************************************************/
	public void addElemento(long idProducto) throws SQLException, Exception {
		DaoProducto dao = new DaoProducto();
		ProductoCarro pc;
		try {
			pc = new ProductoCarro(dao.buscaproductoporid(idProducto), 1);
			int posicion = elementos.indexOf(pc);
			if (posicion == -1) {
				elementos.add(pc);
			} else {
				ProductoCarro actual = elementos.get(posicion);
				actual.setCantidad(actual.getCantidad() + 1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

	/**********************************************************************************/
	public void eliminarElementoCarro(long idProducto) throws SQLException, Exception {
		DaoProducto dao = new DaoProducto();
		ProductoCarro pc;
		try {
			pc = new ProductoCarro(dao.buscaproductoporid(idProducto), 1);
			int posicion = elementos.indexOf(pc);
			if (posicion != -1)
				elementos.remove(posicion);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	/*************************************************************************/
	public void restarElemento(long idProducto) throws SQLException, Exception {
		DaoProducto dao = new DaoProducto();
		try {
			ProductoCarro pc = new ProductoCarro(dao.buscaproductoporid(idProducto), 1);
			pc.setId(idProducto);
			int posicion = elementos.indexOf(pc);
			if (posicion != -1) {
				ProductoCarro actual = elementos.get(posicion);
				actual.setCantidad(actual.getCantidad() - 1);
				if (actual.getCantidad() == 0)
					eliminarElementoCarro(idProducto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/***************************************************************************/
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		ArrayList<ProductoCarro> carroactual = getElementos();
		for (ProductoCarro p : carroactual) {
			// total+=(p.getPrecio_normal()*+p.getCantidad());
			total = total.add(p.getPrecio_normal().multiply(BigDecimal.valueOf(p.getCantidad())));
		}
		System.out.println("El precio actual del carro es: " + total);
		return total;
	}

	/**********************************************************************************/
	public void crearPedido(long cliente, String direccionenvio) throws ClienteException, SQLException, Exception {
		DaoCliente daocliente = new DaoCliente();
		Pedido nuevo = new Pedido();
		DaoPedido dao = new DaoPedido();
		DaoDetallePedido daodetalle = new DaoDetallePedido();
		String ordenSQL;
		ResultSet rs = null;
		Statement st = null;
		Conexion miconex = null;
		Connection con = null;
		try {
			Cliente micliente = daocliente.buscaclienteporid(cliente);
			if (micliente == null)
				throw new ClienteException("Cliente con Id=" + cliente + " no encontrado");
			miconex = new Conexion();
			con = miconex.getConexion();
			con.setAutoCommit(false);
			st = con.createStatement();
			ordenSQL = "select S_PEDIDO.NEXTVAL CODIGOPEDIDO FROM DUAL";
			rs = st.executeQuery(ordenSQL);
			rs.next();
			nuevo.setIdpedido(rs.getLong("CODIGOPEDIDO"));
			rs.close();
			nuevo.setIdcliente(cliente);
			nuevo.setFecha(java.sql.Date.valueOf(LocalDate.now()) );
			nuevo.setDirecciondeenvio(direccionenvio);
			dao.insertaPedido(nuevo, con);
			// ahora añadimos las lineas de detalle del pedido
			int i = 1;
			for (ProductoCarro prod : elementos) {
				DetallePedido dp = new DetallePedido();
				dp.setIdpedido(nuevo.getIdpedido());
				dp.setLineadetalle(i);
				dp.setIdproducto(prod.getId());
				dp.setCantidad(prod.getCantidad());
				dp.setPrecio_unitario(prod.getPrecio_normal());
				dp.setTotal_lineadetalle(dp.getPrecio_unitario().multiply(BigDecimal.valueOf(dp.getCantidad())));
				daodetalle.insertaDetallePedido(dp, con);
				i++;
			}
			con.commit();
		} catch (ClienteException ce) {
			ce.printStackTrace();
			throw ce;
		} catch (SQLException se) {
			se.printStackTrace();
			con.rollback();
			throw se;
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
	}
}

