package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the RUTA database table.
 * 
 */
@Entity
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descripcion;

	private String imagen;

	@Column(name="\"LINK\"")
	private String link;

	private String nombre;

	//bi-directional many-to-one association to Punto
	@OneToMany(mappedBy="rutaBean")
	private List<Punto> puntos;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="CIUDAD")
	private Ciudad ciudadBean;

	public Ruta() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Punto> getPuntos() {
		return this.puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Punto addPunto(Punto punto) {
		getPuntos().add(punto);
		punto.setRutaBean(this);

		return punto;
	}

	public Punto removePunto(Punto punto) {
		getPuntos().remove(punto);
		punto.setRutaBean(null);

		return punto;
	}

	public Ciudad getCiudadBean() {
		return this.ciudadBean;
	}

	public void setCiudadBean(Ciudad ciudadBean) {
		this.ciudadBean = ciudadBean;
	}

}