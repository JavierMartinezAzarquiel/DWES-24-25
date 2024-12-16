package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EQUIPO database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String imgescudo;

	private String imgestadio;

	private String nombre;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipoBean")
	private List<Jugador> jugadors;

	public Equipo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImgescudo() {
		return this.imgescudo;
	}

	public void setImgescudo(String imgescudo) {
		this.imgescudo = imgescudo;
	}

	public String getImgestadio() {
		return this.imgestadio;
	}

	public void setImgestadio(String imgestadio) {
		this.imgestadio = imgestadio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setEquipoBean(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setEquipoBean(null);

		return jugador;
	}

}