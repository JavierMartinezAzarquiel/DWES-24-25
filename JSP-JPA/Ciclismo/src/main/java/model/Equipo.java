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
	private long idequipo;

	private Integer anofundacion;

	private String director;

	private String nombr;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="equipo")
	private List<Participante> participantes;

	public Equipo() {
	}

	public long getIdequipo() {
		return this.idequipo;
	}

	public void setIdequipo(long idequipo) {
		this.idequipo = idequipo;
	}

	public Integer getAnofundacion() {
		return this.anofundacion;
	}

	public void setAnofundacion(Integer anofundacion) {
		this.anofundacion = anofundacion;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getNombr() {
		return this.nombr;
	}

	public void setNombr(String nombr) {
		this.nombr = nombr;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setEquipo(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setEquipo(null);

		return participante;
	}

}