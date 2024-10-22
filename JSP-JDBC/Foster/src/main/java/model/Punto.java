package model;

public class Punto {
	private int id;
	private int idproducto;
	private int puntos;
	public Punto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Punto(int id, int idproducto, int puntos) {
		super();
		this.id = id;
		this.idproducto = idproducto;
		this.puntos = puntos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Punto [id=" + id + ", idproducto=" + idproducto + ", puntos=" + puntos + "]";
	}
	
}
