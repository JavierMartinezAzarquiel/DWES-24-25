package model;

public class Producto {
	private int id;
	private String titulo;
	private String imagen;
	private String body;
	private int categoriaid;
	private String sumario;
	private String fondo;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String titulo, String imagen, String body, int categoriaid, String sumario, String fondo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
		this.body = body;
		this.categoriaid = categoriaid;
		this.sumario = sumario;
		this.fondo = fondo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(int categoriaid) {
		this.categoriaid = categoriaid;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", body=" + body + ", categoriaid="
				+ categoriaid + ", sumario=" + sumario + ", fondo=" + fondo + "]";
	}
	
}
