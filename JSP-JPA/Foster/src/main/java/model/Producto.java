package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCTO database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="\"BODY\"")
	private String body;

	private String fondo;

	private String imagen;

	private String sumario;

	private String titulo;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="CATEGORIAID")
	private Categoria categoria;

	//bi-directional many-to-one association to Punto
	@OneToMany(mappedBy="producto")
	private List<Punto> puntos;

	public Producto() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFondo() {
		return this.fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getSumario() {
		return this.sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Punto> getPuntos() {
		return this.puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Punto addPunto(Punto punto) {
		getPuntos().add(punto);
		punto.setProducto(this);

		return punto;
	}

	public Punto removePunto(Punto punto) {
		getPuntos().remove(punto);
		punto.setProducto(null);

		return punto;
	}

}