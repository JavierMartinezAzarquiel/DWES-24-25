package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the MUNICIPIO database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="PROVINCIA")
	private Provincia provinciaBean;

	//bi-directional many-to-one association to Playa
	@OneToMany(mappedBy="municipioBean")
	private List<Playa> playas;

	public Municipio() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvinciaBean() {
		return this.provinciaBean;
	}

	public void setProvinciaBean(Provincia provinciaBean) {
		this.provinciaBean = provinciaBean;
	}

	public List<Playa> getPlayas() {
		return this.playas;
	}

	public void setPlayas(List<Playa> playas) {
		this.playas = playas;
	}

	public Playa addPlaya(Playa playa) {
		getPlayas().add(playa);
		playa.setMunicipioBean(this);

		return playa;
	}

	public Playa removePlaya(Playa playa) {
		getPlayas().remove(playa);
		playa.setMunicipioBean(null);

		return playa;
	}

}