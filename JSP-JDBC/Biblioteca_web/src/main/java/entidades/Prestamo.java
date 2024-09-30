package entidades;

import java.util.Date;

public class Prestamo {
    private int idejemplar; 
    private String titulo;
    private long idsocio;
    private String nombreSocio;
	private Date fechaprestamo; 
    private Date fechalimitedevolucion; 
    private int diasDemora;
    public Prestamo() {
    }

    public void setIdejemplar(int idejemplar) {
        this.idejemplar = idejemplar;
    }

    public int getIdejemplar() {
        return idejemplar;
    }

    public void setIdsocio(long idsocio) {
        this.idsocio = idsocio;
    }

    public long getIdsocio() {
        return idsocio;
    }
    public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechalimitedevolucion(Date fechalimitedevolucion) {
        this.fechalimitedevolucion = fechalimitedevolucion;
    }

    public Date getFechalimitedevolucion() {
        return fechalimitedevolucion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDiasDemora(int diasDemora) {
        this.diasDemora = diasDemora;
    }

    public int getDiasDemora() {
        return diasDemora;
    }
}

