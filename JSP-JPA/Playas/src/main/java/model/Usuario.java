package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findByNick", query="SELECT u FROM Usuario u WHERE u.nick = :nick AND u.pass = :pass")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nick;

	private String pass;

	//bi-directional many-to-one association to Punto
	@OneToMany(mappedBy="usuarioBean")
	private List<Punto> puntos;

	public Usuario() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Punto> getPuntos() {
		return this.puntos;
	}

	public void setPuntos(List<Punto> puntos) {
		this.puntos = puntos;
	}

	public Punto addPunto(Punto punto) {
		getPuntos().add(punto);
		punto.setUsuarioBean(this);

		return punto;
	}

	public Punto removePunto(Punto punto) {
		getPuntos().remove(punto);
		punto.setUsuarioBean(null);

		return punto;
	}

}