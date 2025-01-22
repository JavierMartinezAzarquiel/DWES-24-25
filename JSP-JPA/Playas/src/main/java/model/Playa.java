package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the PLAYA database table.
 * 
 */
@Entity
@NamedQuery(name="Playa.findAll", query="SELECT p FROM Playa p")
public class Playa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="playaBean")
	private List<Image> images;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="MUNICIPIO")
	private Municipio municipioBean;

	//bi-directional many-to-one association to Punto
	@OneToMany(mappedBy="playaBean")
	private List<Punto> puntos;

	public Playa() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setPlayaBean(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setPlayaBean(null);

		return image;
	}

	public Municipio getMunicipioBean() {
		return this.municipioBean;
	}

	public void setMunicipioBean(Municipio municipioBean) {
		this.municipioBean = municipioBean;
	}

	public List<Punto> getPuntos() {
		return this.puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Punto addPunto(Punto punto) {
		getPuntos().add(punto);
		punto.setPlayaBean(this);

		return punto;
	}

	public Punto removePunto(Punto punto) {
		getPuntos().remove(punto);
		punto.setPlayaBean(null);

		return punto;
	}

}