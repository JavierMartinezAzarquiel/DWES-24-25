package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the JUGADOR database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private int edad;

	private float estatura;

	private String imagen;

	private int likes;

	@Column(name="\"LINK\"")
	private String link;

	private String nombre;

	private String pais;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="EQUIPO")
	private Equipo equipoBean;

	public Jugador() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getEstatura() {
		return this.estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Equipo getEquipoBean() {
		return this.equipoBean;
	}

	public void setEquipoBean(Equipo equipoBean) {
		this.equipoBean = equipoBean;
	}

}