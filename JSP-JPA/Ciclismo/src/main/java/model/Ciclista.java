package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CICLISTA database table.
 * 
 */
@Entity
@NamedQuery(name="Ciclista.findAll", query="SELECT c FROM Ciclista c")
public class Ciclista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idciclista;

	private String nombrec;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="ciclista")
	private List<Participante> participantes;

	public Ciclista() {
	}

	public long getIdciclista() {
		return this.idciclista;
	}

	public void setIdciclista(long idciclista) {
		this.idciclista = idciclista;
	}

	public String getNombrec() {
		return this.nombrec;
	}

	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setCiclista(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setCiclista(null);

		return participante;
	}

}