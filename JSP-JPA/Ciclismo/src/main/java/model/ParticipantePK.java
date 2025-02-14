package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the PARTICIPANTE database table.
 * 
 */
@Embeddable
public class ParticipantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idedicion;

	@Column(insertable=false, updatable=false)
	private long idciclista;

	public ParticipantePK() {
	}
	public long getIdedicion() {
		return this.idedicion;
	}
	public void setIdedicion(long idedicion) {
		this.idedicion = idedicion;
	}
	public long getIdciclista() {
		return this.idciclista;
	}
	public void setIdciclista(long idciclista) {
		this.idciclista = idciclista;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ParticipantePK)) {
			return false;
		}
		ParticipantePK castOther = (ParticipantePK)other;
		return 
			(this.idedicion == castOther.idedicion)
			&& (this.idciclista == castOther.idciclista);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idedicion ^ (this.idedicion >>> 32)));
		hash = hash * prime + ((int) (this.idciclista ^ (this.idciclista >>> 32)));
		
		return hash;
	}
}