package model;

public class Ruta {

	private int id;
	private int ciudad;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String link;
	private int media;
	
	public Ruta() {
		super();
	}

	public Ruta(int id, int ciudad, String nombre, String imagen, String descripcion, String link) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", ciudad=" + ciudad + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion="
				+ descripcion + ", link=" + link + ", media=" + media + "]";
	}

	
	
	
}
