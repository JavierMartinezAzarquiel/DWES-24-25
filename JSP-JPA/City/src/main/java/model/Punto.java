package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PUNTO database table.
 * 
 */
@Entity 
@Cacheable(false)
@NamedQuery(name="Punto.findAll", query="SELECT p FROM Punto p")
public class Punto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int puntos;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="RUTA")
	private Ruta rutaBean;

	public Punto() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Ruta getRutaBean() {
		return this.rutaBean;
	}

	public void setRutaBean(Ruta rutaBean) {
		this.rutaBean = rutaBean;
	}

}