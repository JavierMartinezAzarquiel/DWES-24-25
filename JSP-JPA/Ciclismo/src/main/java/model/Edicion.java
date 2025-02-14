package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the EDICION database table.
 * 
 */
@Entity
@NamedQuery(name="Edicion.findAll", query="SELECT e FROM Edicion e")
public class Edicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idedicion;

	private Integer ano;

	private String llegada;

	private String salida;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="edicion")
	private List<Participante> participantes;

	public Edicion() {
	}

	public long getIdedicion() {
		return this.idedicion;
	}

	public void setIdedicion(long idedicion) {
		this.idedicion = idedicion;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getLlegada() {
		return this.llegada;
	}

	public void setLlegada(String llegada) {
		this.llegada = llegada;
	}

	public String getSalida() {
		return this.salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setEdicion(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setEdicion(null);

		return participante;
	}

}