package entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Autor {
	private int idAutor;
	private String nombre;
	private Date fechaNacimiento;

	public Autor() {
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaNacimientoFormateada() {
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateada = formatoDeFecha.format(fechaNacimiento);
		return fechaFormateada;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", fechaNacimiento=" + getFechaNacimientoFormateada() + "]";
	}


	
}