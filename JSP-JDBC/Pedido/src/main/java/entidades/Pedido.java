package entidades;

import java.sql.Date;


public class Pedido {
    private long idpedido; 
    private long idcliente; 
    private Date fecha;
    private String direcciondeenvio;
    private String estado; 
    private String cobrado; 
    public Pedido() {
    }

    public void setIdpedido(long idpedido) {
        this.idpedido = idpedido;
    }

    public long getIdpedido() {
        return idpedido;
    }

    public void setIdcliente(long idcliente) {
        this.idcliente = idcliente;
    }

    public long getIdcliente() {
        return idcliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDirecciondeenvio(String direcciondeenvio) {
        this.direcciondeenvio = direcciondeenvio;
    }

    public String getDirecciondeenvio() {
        return direcciondeenvio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCobrado(String cobrado) {
        this.cobrado = cobrado;
    }

    public String getCobrado() {
        return cobrado;
    }
}
