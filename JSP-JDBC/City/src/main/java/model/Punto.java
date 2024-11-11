package model;

public class Punto {
	private int id;
	private int ruta;
	private int puntos;
	
	public Punto(int id, int ruta, int puntos) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.puntos = puntos;
	}

	public Punto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRuta() {
		return ruta;
	}

	public void setRuta(int ruta) {
		this.ruta = ruta;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Punto [id=" + id + ", ruta=" + ruta + ", puntos=" + puntos + "]";
	}
	
	
}
