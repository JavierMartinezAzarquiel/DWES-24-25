package entidades;

public class Ejemplar {
	private int idejemplar;
	private String isbn;
	private String titulo;

	public Ejemplar() {

	}

	public int getIdejemplar() {
		return idejemplar;
	}

	public void setIdejemplar(int idejemplar) {
		this.idejemplar = idejemplar;
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

	@Override
	public String toString() {
		return "Ejemplar [idejemplar=" + idejemplar + ", isbn=" + isbn + "]";
	}

}
