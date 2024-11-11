package model;

public class Ciudad {
	private int id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String link;
	private String mapa;
	
	public Ciudad() {
		super();
	}

	public Ciudad(int id, String nombre, String imagen, String descripcion, String link, String mapa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.link = link;
		this.mapa = mapa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
				+ ", link=" + link + ", mapa=" + mapa + "]";
	}
	
}
