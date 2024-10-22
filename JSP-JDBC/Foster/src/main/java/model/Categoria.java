package model;

public class Categoria {
	private int id;
	private String nombre;
	private String descripcion;
	private String guarnicion;
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int id, String nombre, String descripcion, String guarnicion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.guarnicion = guarnicion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGuarnicion() {
		return guarnicion;
	}
	public void setGuarnicion(String guarnicion) {
		this.guarnicion = guarnicion;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", guarnicion="
				+ guarnicion + "]";
	}
	
}
