package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROVINCIA database table.
 * 
 */
@Entity
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="provinciaBean")
	private List<Municipio> municipios;

	//bi-directional many-to-one association to Ccaa
	@ManyToOne
	@JoinColumn(name="CCAA")
	private Ccaa ccaaBean;

	public Provincia() {
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

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setProvinciaBean(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setProvinciaBean(null);

		return municipio;
	}

	public Ccaa getCcaaBean() {
		return this.ccaaBean;
	}

	public void setCcaaBean(Ccaa ccaaBean) {
		this.ccaaBean = ccaaBean;
	}

}