package entidades;

import java.sql.Timestamp;

public class Token {
	private String email;
	private String clave;
	private String value;
	private String telefono;
	private Timestamp fecha;
	
	
	public Token() {
		super();
	}


	public Token(String email, String clave, String value, String telefono, Timestamp fecha) {
		super();
		this.email = email;
		this.clave = clave;
		this.value = value;
		this.telefono = telefono;
		this.fecha = fecha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Token [email=" + email + ", clave=" + clave + ", value=" + value + ", telefono=" + telefono + ", fecha="
				+ fecha + "]";
	}
	
	
	
}
