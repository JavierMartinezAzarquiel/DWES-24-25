package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the PARTICIPANTE database table.
 * 
 */
@Entity
@NamedQuery(name="Participante.findAll", query="SELECT p FROM Participante p")
public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParticipantePK id;

	private Integer dorsal;

	//bi-directional many-to-one association to Ciclista
	@ManyToOne
	@JoinColumn(name="IDCICLISTA")
	private Ciclista ciclista;

	//bi-directional many-to-one association to Edicion
	@ManyToOne
	@JoinColumn(name="IDEDICION")
	private Edicion edicion;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="IDEQUIPO")
	private Equipo equipo;

	public Participante() {
	}

	public ParticipantePK getId() {
		return this.id;
	}

	public void setId(ParticipantePK id) {
		this.id = id;
	}

	public Integer getDorsal() {
		return this.dorsal;
	}

	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public Ciclista getCiclista() {
		return this.ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	public Edicion getEdicion() {
		return this.edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}