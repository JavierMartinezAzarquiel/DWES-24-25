package entidades;

public class Socio {
    private long idsocio;
    private String email;
    private String nombre;
    private String direccion;
    private int version;
    private String clave;

	public Socio() {
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdsocio(long idsocio) {
        this.idsocio = idsocio;
    }

    public long getIdsocio() {
        return idsocio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
    public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Socio [idsocio=" + idsocio + ", email=" + email + ", nombre=" + nombre + ", direccion=" + direccion
				+ "]";
	}  
	
}
