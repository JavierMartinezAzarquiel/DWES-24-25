package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the PUNTO database table.
 * 
 */
@Entity
@NamedQuery(name="Punto.findAll", query="SELECT p FROM Punto p")
public class Punto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int puntos;

	//bi-directional many-to-one association to Playa
	@ManyToOne
	@JoinColumn(name="PLAYA")
	private Playa playaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO")
	private Usuario usuarioBean;

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

	public Playa getPlayaBean() {
		return this.playaBean;
	}

	public void setPlayaBean(Playa playaBean) {
		this.playaBean = playaBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}