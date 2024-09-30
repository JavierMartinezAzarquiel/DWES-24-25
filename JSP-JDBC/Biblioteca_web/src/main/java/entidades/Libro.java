package entidades;

public class Libro {
	private String isbn;
	private String titulo;
	private int idautor;
	private String nombreAutor;
	private int ejemplaresTotales;
	private int ejemplaresEnPrestamo;
	private int ejemplaresDisponibles;
	public Libro(){
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getIdautor() {
		return idautor;
	}
	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public int getEjemplaresTotales() {
		return ejemplaresTotales;
	}
	public void setEjemplaresTotales(int ejemplaresTotales) {
		this.ejemplaresTotales = ejemplaresTotales;
	}
	public int getEjemplaresEnPrestamo() {
		return ejemplaresEnPrestamo;
	}
	public void setEjemplaresEnPrestamo(int ejemplaresEnPrestamo) {
		this.ejemplaresEnPrestamo = ejemplaresEnPrestamo;
	}
	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}
	public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", idautor=" + idautor + ", nombreAutor=" + nombreAutor
				+ ", ejemplaresTotales=" + ejemplaresTotales + ", ejemplaresEnPrestamo=" + ejemplaresEnPrestamo
				+ ", ejemplaresDisponibles=" + ejemplaresDisponibles + "]";
	}
	
	
}
