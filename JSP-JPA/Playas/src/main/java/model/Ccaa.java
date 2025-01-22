package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CCAA database table.
 * 
 */
@Entity
@NamedQuery(name="Ccaa.findAll", query="SELECT c FROM Ccaa c")
public class Ccaa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="ccaaBean")
	private List<Provincia> provincias;

	public Ccaa() {
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

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia addProvincia(Provincia provincia) {
		getProvincias().add(provincia);
		provincia.setCcaaBean(this);

		return provincia;
	}

	public Provincia removeProvincia(Provincia provincia) {
		getProvincias().remove(provincia);
		provincia.setCcaaBean(null);

		return provincia;
	}

}