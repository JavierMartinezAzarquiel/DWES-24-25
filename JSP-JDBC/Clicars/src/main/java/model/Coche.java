package model;

public class Coche {
	private int id;
	private int marca;
	private String foto;
	private String nombre;
	private String modelo;
	private int precio;
	private int precioantes;
	private int anio;
	private int km;
	private int cv;
	private int fav;
	private int likes;
	
	public Coche() {
		super();
	}

	public Coche(int id, int marca, String foto, String nombre, String modelo, int precio, int precioantes, int anio,
			int km, int cv, int fav, int likes) {
		super();
		this.id = id;
		this.marca = marca;
		this.foto = foto;
		this.nombre = nombre;
		this.modelo = modelo;
		this.precio = precio;
		this.precioantes = precioantes;
		this.anio = anio;
		this.km = km;
		this.cv = cv;
		this.fav = fav;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPrecioantes() {
		return precioantes;
	}

	public void setPrecioantes(int precioantes) {
		this.precioantes = precioantes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", foto=" + foto + ", nombre=" + nombre + ", modelo=" + modelo
				+ ", precio=" + precio + ", precioantes=" + precioantes + ", anio=" + anio + ", km=" + km + ", cv=" + cv
				+ ", fav=" + fav + ", likes=" + likes + "]";
	}
	
	
}
