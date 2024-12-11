package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the CIUDAD database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c"),
	@NamedQuery(name="Ciudad.conRutas", query="SELECT c FROM Ciudad c WHERE c.id IN (SELECT r.ciudadBean.id FROM Ruta r)")
})
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descripcion;

	private String imagen;

	@Column(name="\"LINK\"")
	private String link;

	private String mapa;

	private String nombre;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="ciudadBean")
	private List<Ruta> rutas;

	public Ciudad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMapa() {
		return this.mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ruta> getRutas() {
		return this.rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public Ruta addRuta(Ruta ruta) {
		getRutas().add(ruta);
		ruta.setCiudadBean(this);

		return ruta;
	}

	public Ruta removeRuta(Ruta ruta) {
		getRutas().remove(ruta);
		ruta.setCiudadBean(null);

		return ruta;
	}

}