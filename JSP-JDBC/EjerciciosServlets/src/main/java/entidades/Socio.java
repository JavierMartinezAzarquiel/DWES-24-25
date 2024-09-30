package entidades;

public class Socio {
    private int idsocio;
    private String nombre;
    private String apellidos;
    private String nif;
    private String email;

	public Socio() {
    }
	// setter 
	public void setIdsocio(int idsocio) { this.idsocio=idsocio;}
	public void setNombre(String nombre) {this.nombre=nombre;}
	public void setApellidos(String apellidos) {this.apellidos=apellidos;}
	public void setNif(String nif) {this.nif=nif;}
	public void setEmail(String email) {this.email=email;}
	// getter
	public int getIdsocio() { return idsocio;}
	public String getNombre() {return nombre;}
	public String getApellidos() {return apellidos;}
	public String getNif() {return nif;}
	public String getEmail() {return email;}
	// gestión ID
	/*public void setIdsocio(long idsocio) {this.idsocio = idsocio;}
    public long getIdsocio() {return idsocio;}*/
	@Override
	public String toString() {
		return "Socio [idsocio=" + idsocio + ", "
				+ "nombre=" + nombre + ", "
				+ "apellidos=" + apellidos + ", "
				+ "nif=" + nif + ", "
				+ "email=" + email + ", "
				+ "]";
	}  
}

